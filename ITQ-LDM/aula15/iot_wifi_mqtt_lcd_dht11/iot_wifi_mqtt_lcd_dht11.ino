#include "DHT.h"
#include <Wire.h>
#include <LiquidCrystal_I2C.h>
#include <WiFi.h>
#include <PubSubClient.h>

#define DHTPIN 5
#define DHTTYPE DHT11
#define ende  0x27 //Define o endereço do display

DHT dht(DHTPIN, DHTTYPE);

const char* ssid = "BarberiniTaboao";
const char* password = "26042021";

const char* mqtt_server = "192.168.68.101";
const char* mqtt_topic = "sensor/temp";
const char* mqtt_clientid = "esp32_client";

const int PAUSA=30;

LiquidCrystal_I2C lcd(ende, 16, 2); 
WiFiClient espClient;
PubSubClient client(espClient);

int connected = 0;
int mqtt_connected = 0;

void setup() {
  lcd.init();
  lcd.backlight();
  // lcd.noBacklight();
  lcd.clear();
  dht.begin();

  WiFi.mode(WIFI_STA);

  lcd.setCursor(0, 1);
  lcd.print(ssid);
  lcd.setCursor(0, 0);
  lcd.print("Connecting to ");



  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    lcd.print(".");
  }

  client.setServer( mqtt_server, 1894 );
 
  connected = 1;
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("WiFi connected");
  lcd.setCursor(0, 1);
  lcd.print("IP: ");
  lcd.print(WiFi.localIP());
  delay(5000);
}

void reconnect() {
  while (!client.connected()) {
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Connecting MQ");
    lcd.setCursor(0, 1);
    lcd.print(".");
    if (client.connect( mqtt_clientid )) {
      mqtt_connected = 1;
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print("MQ Connected");
    } else {
      mqtt_connected = 0;
      lcd.print(".");
      delay(2000);
    }
  }
}

void loop() {
  lcd.clear();
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  float h = dht.readHumidity();
  // Read temperature as Celsius (the default)
  float t = dht.readTemperature();

  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print(t);

  lcd.setCursor(13, 0);
  if (connected) {
    if (mqtt_connected) {
      lcd.print("<*>");
    } else { 
      lcd.print("< >");
    }
  } else {
    lcd.print("!#!");
  }

  lcd.setCursor(0, 1);
  lcd.print("Umid: ");
  lcd.print(h);

  if (!isnan(t) && !isnan(h)) {
    lcd.setCursor(13, 1);
    lcd.print(".");
    String carga = "{\"temp\":" + String(t) + ",\"umd\":" + String(h) + "}";
    lcd.print(".");
    client.publish(mqtt_topic, carga.c_str());
    lcd.print(".");
    lcd.setCursor(13, 1);
    lcd.print("%");
  } else { 
    lcd.setCursor(13, 1);
    lcd.print("-");
  }

  delay(PAUSA * 1000);
}