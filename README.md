# SYSC 3010 Group Project
## Group M8: Dailin Luo, Hanshan Wang, Viktor Dimitrov & Jonathan Arava

All the project files that were used to run the car during demonstration can be found within the master
branch of this current repository (groupM8).

More information about the Android Application can be found in this repository:
https://github.com/dailinluo/android

To run this project, please follow these steps:

*In order to let the video streaming & interaction between the components work properly, please make
sure to connect the Android phone, Raspberry Pi (Pi camera and the vehicle motor) over the same
network/wifi (localhost). Video stream performance over Wi-Fi depends on the Wi-Fi speeds. For best
streaming quality, the stream can be accessed on the RPi itself locally by going to
http://<Pi_IP_Address>:8000*

1. Run database.py on the RPi 1

2. Download the files from the CarPrograms folder on Github to the RPi 3 on the car, and enter the
following in the command window:

sudo python smartsurveillance_car.py

sudo python smartsurveillance_speed.py

sudo python3 smartsurveillance_stream.py

3. Open up the browser on your computer (make sure you have set up remote access to your RPi 3
from your computer using VNC) and enter the following:

192.168.0.104:321

4. Control the car using the “WASD” key on the keyboard, or using the four pink buttons on the
website as forward, backwards, left and right

5. To open up the Android application, download and install the "app-debug.apk" file to your Android
phone from the AndroidApplication folder within the Github Repository

6. Once you open the application, you need to register for a username and password to use the
application. Please click the "No account? Register here" button to create a username and
password

7. Go back to the sign-in page to login. Once logged in, the video streaming tab will pop up and you
can watch the live stream (performance will vary depending on Wi-Fi speeds). *The video
streaming tab that will open will be the URL that is used for our Raspberry Pi as it is IP address
dependent. In order to use it with your Pi, you must edit the Webview.java file of the Android
application and enter your URL there in the format: http://<Pi_IP_Address>:8000*
