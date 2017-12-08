from flask import Flask
import sqlite3
app = Flask(__name__)

@app.route("/<name>")

def hello(name):
    
    #insert name in db
    conn = sqlite3.connect('/home/pi/test.db')
    c = conn.cursor()
    id= c.lastrowid
    c.execute('insert into Users values (?,?)', (id, name))
    conn.commit()
      
    

    return '%s' %name

if __name__ == '__main__':

    app.run(host='0.0.0.0')
    
    




