import sys
import RPi.GPIO as GPIO
import time
import urllib2
OUT1 = 21
OUT2 = 22
leftCount = 0
rightCount = 0
def init():
        GPIO.setmode(GPIO.BOARD)
        GPIO.setup(OUT1, GPIO.IN, pull_up_down = GPIO.PUD_UP)
        GPIO.setup(OUT2, GPIO.IN, pull_up_down = GPIO.PUD_UP)
def leftCallback(channel1):
        global leftCount
        leftCount = leftCount + 1
        print("Left Callback: %d" % leftCount)
def rightCallback(channel2):
        global rightCount
        rightCount = rightCount + 1
        print("Right Callback: %d" % rightCount)
def recount():
        global leftCount
        global rightCount
        leftRPS = float(leftCount) / 20
        rightRPS = float(rightCount) / 20
        print("left RPS: %f, right RPS: %f." % (leftRPS, rightRPS))
        #==============================
        url = ("http://192.168.0.101:5000/%.2f|%.2f" % (leftRPS, rightRPS))
        urllib2.urlopen(url)
        #==============================
        leftCount = 0
        rightCount = 0
        
init()
GPIO.add_event_detect(OUT1, GPIO.RISING, callback = leftCallback)
GPIO.add_event_detect(OUT2, GPIO.RISING, callback = rightCallback)
try:
        while True:
                time.sleep(1)
                recount()
finally:
        GPIO.cleanup()
