//right
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)

IN1 = 11
IN2 = 12
IN3 = 13
IN4 = 15

GPIO.setup(IN1,GPIO.OUT)
GPIO.setup(IN2,GPIO.OUT)
GPIO.setup(IN3,GPIO.OUT)
GPIO.setup(IN4,GPIO.OUT)

GPIO.output(IN1,GPIO.HIGH)
GPIO.output(IN2,GPIO.LOW)
GPIO.output(IN3,False)
GPIO.output(IN4,False)

time.sleep(2)
GPIO.cleanup()