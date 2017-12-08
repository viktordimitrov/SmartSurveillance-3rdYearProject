import sys
import RPi.GPIO as GPIO
import time
import tornado.ioloop
import tornado.web
import tornado.httpserver
import tornado.options
import urllib2
from tornado.options import define,options
define("port",321,type=int)
IN1 = 11
IN2 = 12
IN3 = 13
IN4 = 15
def init():
        GPIO.setmode(GPIO.BOARD)
        GPIO.setup(IN1,GPIO.OUT)
        GPIO.setup(IN2,GPIO.OUT)
        GPIO.setup(IN3,GPIO.OUT)
        GPIO.setup(IN4,GPIO.OUT)
def forward(tf):
        GPIO.output(IN1,GPIO.HIGH)
        GPIO.output(IN2,GPIO.LOW)
        GPIO.output(IN3,GPIO.HIGH)
        GPIO.output(IN4,GPIO.LOW)
        print("forward")
        time.sleep(tf)
        GPIO.cleanup()
def backOff(tf):
        GPIO.output(IN1,GPIO.LOW)
        GPIO.output(IN2,GPIO.HIGH)
        GPIO.output(IN3,GPIO.LOW)
        GPIO.output(IN4,GPIO.HIGH)
        print("backOff")
        time.sleep(tf)
        GPIO.cleanup()
def left(tf):
        GPIO.output(IN1,GPIO.LOW)
        GPIO.output(IN2,GPIO.LOW)
        GPIO.output(IN3,GPIO.HIGH)
        GPIO.output(IN4,GPIO.LOW)
        print("left")
        time.sleep(tf)
        GPIO.cleanup()
def right(tf):
        GPIO.output(IN1,GPIO.HIGH)
        GPIO.output(IN2,GPIO.LOW)
        GPIO.output(IN3,GPIO.LOW)
        GPIO.output(IN4,GPIO.LOW)
        print("right")
        time.sleep(tf)
        GPIO.cleanup()
def leftBack(tf):
        GPIO.output(IN1,GPIO.LOW)
        GPIO.output(IN2,GPIO.HIGH)
        GPIO.output(IN3,GPIO.LOW)
        GPIO.output(IN4,GPIO.LOW)
        print("leftBack")
        time.sleep(tf)
        GPIO.cleanup()
def rightBack(tf):
        GPIO.output(IN1,GPIO.LOW)
        GPIO.output(IN2,GPIO.LOW)
        GPIO.output(IN3,GPIO.LOW)
        GPIO.output(IN4,GPIO.HIGH)
        print("rightBack")
        time.sleep(tf)
        GPIO.cleanup()
def leftRotation(tf):
        GPIO.output(IN1,GPIO.LOW)
        GPIO.output(IN2,GPIO.HIGH)
        GPIO.output(IN3,GPIO.HIGH)
        GPIO.output(IN4,GPIO.LOW)
        print("leftRotation")
        time.sleep(tf)
        GPIO.cleanup()
def rightRotation(tf):
        GPIO.output(IN1,GPIO.HIGH)
        GPIO.output(IN2,GPIO.LOW)
        GPIO.output(IN3,GPIO.LOW)
        GPIO.output(IN4,GPIO.HIGH)
        print("rightRotation")
        time.sleep(tf)
        GPIO.cleanup()
class IndexHandler(tornado.web.RequestHandler):
        def get(self):
                self.render("index.html")
        def post(self):
                init()
                sleep_time = 0.1
                arg = self.get_argument('k')
                if(arg=='w'):
                        forward(sleep_time)
                        url = ("http://192.168.0.101:5000/forward")
                        urllib2.urlopen(url)
                elif(arg=='s'):
                        backOff(sleep_time)
                        url = ("http://192.168.0.101:5000/backOff")
                        urllib2.urlopen(url)
                elif(arg=='a'):
                        left(sleep_time)
                        url = ("http://192.168.0.101:5000/left")
                        urllib2.urlopen(url)
                elif(arg=='d'):
                        right(sleep_time)
                        url = ("http://192.168.0.101:5000/right")
                        urllib2.urlopen(url)
                elif(arg=='z'):
                        leftBack(sleep_time)
                        url = ("http://192.168.0.101:5000/leftback")
                        urllib2.urlopen(url)
                elif(arg=='x'):
                        rightBack(sleep_time)
                        url = ("http://192.168.0.101:5000/rightback")
                        urllib2.urlopen(url)
                elif(arg=='q'):
                        leftRotation(sleep_time)
                        url = ("http://192.168.0.101:5000/leftRotation")
                        urllib2.urlopen(url)
                elif(arg=='e'):
                        rightRotation(sleep_time)
                        url = ("http://192.168.0.101:5000/rightRotation")
                        urllib2.urlopen(url)
                else:
                        return False
                self.write(arg)
if __name__ == '__main__':
        tornado.options.parse_command_line()
        app = tornado.web.Application(handlers=[(r"/",IndexHandler)])
        http_server = tornado.httpserver.HTTPServer(app)
        http_server.listen(options.port)
        tornado.ioloop.IOLoop.instance().start()
