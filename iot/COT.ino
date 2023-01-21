#include <NTPClient.h>
#include <ESP8266WiFi.h>
#include <WiFiUdp.h>



#define TRIG D1
#define ECHO D0

#define LED D2
#define LED_2 D3

#define LDR A0

float distance, duration;
const char *ssid = "LAPTOP-R6SDAQ49 8789";  // replace with your wifi ssid and wpa2 key
const char *pass = "123456789";

const long utcOffsetInSeconds = 3600;

char daysOfTheWeek[7][12] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

// Define NTP Client to get time
WiFiUDP ntpUDP;
NTPClient timeClient(ntpUDP, "pool.ntp.org", utcOffsetInSeconds);

bool detectedCar = false;
unsigned long epochtime;
unsigned long shutdownTime;

void setup() {
  pinMode(D2, OUTPUT);
  Serial.begin(9600);
  // put your setup code here, to run once:

  WiFi.begin(ssid, pass);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  timeClient.begin();
  pinMode(LED, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LDR, INPUT);
  pinMode(TRIG, OUTPUT);
  pinMode(ECHO, INPUT);
  shutdownTime = timeClient.getEpochTime();
}

void loop() {
  // put your main code here, to run repeatedly:
  int hours = timeClient.getHours();
  long long epochtime = timeClient.getEpochTime();
  Serial.print(hours);
  if (hours > 18 || hours < 5) {
    int lightIntensity = analogRead(LDR);
    int ledOutput = (int) ((1 - ((float)lightIntensity/1024.0)) * 255);
    Serial.print(ledOutput);
    digitalWrite(TRIG, LOW);
    delayMicroseconds(2);
    digitalWrite(TRIG, HIGH);
    delayMicroseconds(10);
    digitalWrite(TRIG, LOW);
    duration = pulseIn(ECHO, HIGH);
    distance = duration * 0.034 / 2;
    Serial.print(": ambient light lvl = ");
    Serial.println(lightIntensity);
    Serial.println("Distance from UlraSound: ");
    Serial.println(distance);
    if (distance < 20) {
      analogWrite(LED, ledOutput);
      analogWrite(LED_2, ledOutput);
      shutdownTime = timeClient.getEpochTime() + 5;
    } else if(timeClient.getEpochTime() > shutdownTime){
      analogWrite(LED, LOW);
      analogWrite(LED_2, LOW);
    }
  } else {
    // delay(5000);
    digitalWrite(LED, LOW);
  }
}
