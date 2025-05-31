#include <DHT.h>

#define SENSOR_PIN 5

DHT dht11(SENSOR_PIN, DHT11);

void setup() {
  Serial.begin(115200);
  Serial.println("Leitor de Temperatura e Umidade");
  dht11.begin();
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(1000); // this speeds up the simulation

  float humi  = dht11.readHumidity();
  float tempC = dht11.readTemperature();

  Serial.print("Temperatura: ");
  Serial.print(tempC);
  Serial.print("    Umidade: ");
  Serial.println(humi);

}
