void setup() {
  pinMode(4, INPUT);
  pinMode(5, OUTPUT);
  digitalWrite(5, LOW);
}

void loop() {

  int pinValue = digitalRead(4);

  if (pinValue == HIGH) {
    digitalWrite(5, HIGH);
  } else {
    digitalWrite(5, LOW);
  }

}
