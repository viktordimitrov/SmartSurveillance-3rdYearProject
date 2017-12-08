# Import of necessary packages
import io
import picamera
import socketserver
from threading import Lock
from http import server

# HTML Code for the displayed web page
PAGE= """\ 
<html>
<head>
<title>Smart Surveillance</title>
</head>
<body>
<center><h1>Smart Surveillance - Video Live Stream</h1></center>
<center><img src="stream.mjpg" width="640" height="480"></center>
</body>
</html>
""" 

# Handles the stream output
class StreamingOutput(object):
    def __init__(self):
        self.lock = Lock()
        self.frame = io.BytesIO() # Stream frame
        self.clients = [] # Streaming clients
        
    def write(self, buf):
        died = []
        if buf.startswith(b'\xff\xd8'):
            # Starts a new frame, and sends old frame contents to connected clients
            size = self.frame.tell()
            if size > 0: # Sends frame to client if the frame has contents
                self.frame.seek(0)
                data = self.frame.read(size)
                self.frame.seek(0)
                with self.lock:
                    for client in self.clients:
                        try: 
                            client.wfile.write(b'--FRAME\r\n')
                            # Writes a specific HTTP Header to the output stream
                            # The format is (keyword, value)                            
                            client.send_header('Content-Type', 'image/jpeg')
                            client.send_header('Content-Length', size)
                            client.end_headers()
                            client.wfile.write(data)
                            client.wfile.write(b'\r\n')
                        except Exception as e:
                            died.append(client) 
        self.frame.write(buf)
        if died: # All clients removed if stream is interrupted
            self.remove_clients(died)
 
    def flush(self): # Flushes all clients
        with self.lock:
            for client in self.clients:
                client.wfile.close()
 
    def add_client(self, client): # Client added to stream
        print('Adding streaming client %s:%d' % client.client_address)
        with self.lock:
            self.clients.append(client)
 
    def remove_clients(self, clients): # Client removed from stream
        with self.lock:
            for client in clients:
                try:
                    print('Removing streaming client %s:%d' % client.client_address)
                    self.clients.remove(client)
                except ValueError:
                    pass # Client has already been removed
 
# Handles the HTTP Server
class StreamingHandler(server.BaseHTTPRequestHandler):
    def do_GET(self):
        if self.path == '/':
            # Sends reponse code 301
            self.send_response(301)
            self.send_header('Location', '/index.html') 
            self.end_headers()
        elif self.path == '/index.html':
            content = PAGE.encode('utf-8') # Character encoding for web page
            self.send_response(200)
            self.send_header('Content-Type', 'text/html')
            self.send_header('Content-Length', len(content))
            self.end_headers()
            # Sends stream content to client by writing it to wfile
            self.wfile.write(content)
        elif self.path == '/stream.mjpg': # Name and format of the stream
            self.close_connection = False
            # Sends reponse code 200
            self.send_response(200)
            self.send_header('Age', 0)
            self.send_header('Cache-Control', 'no-cache, private')
            self.send_header('Pragma', 'no-cache')
            self.send_header('Content-Type', 'multipart/x-mixed-replace; boundary=--FRAME')
            self.end_headers()
            output.add_client(self)
        else:
            # Sends error reply to the client, with HTTP error code 404
            self.send_error(404)
            self.end_headers()
 
class StreamingServer(socketserver.ThreadingMixIn, server.HTTPServer):
    pass
 
# Sets the resolution and framerate of the stream and outputs it
with picamera.PiCamera(resolution='640x480', framerate=30) as camera:
    output = StreamingOutput()
    camera.start_recording(output, format='mjpeg') # MJPEG format for stream
    try:
        address = ('', 8000) # Stream on port 8000
        #Stream can be accessed at "http://<Pi_IP_Address>:8000"
        server = StreamingServer(address, StreamingHandler)
        server.serve_forever()
    finally:
        camera.stop_recording()