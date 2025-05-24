void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Hello, ESP32!");
  pinMode(5, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(500); // this speeds up the simulation
  digitalWrite(5, HIGH);
  delay(500); // this speeds up the simulation
  digitalWrite(5, LOW);  
}
