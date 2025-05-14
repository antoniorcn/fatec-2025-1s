#define LED_BUILTIN 2
#define TIME 100

void setup() {
  pinMode(LED_BUILTIN, OUTPUT); // Tente também 4 ou 5 se o LED não piscar
}

void loop() {
  digitalWrite(LED_BUILTIN, HIGH);
  delay(TIME);
  digitalWrite(LED_BUILTIN, LOW);
  delay(TIME);
}
