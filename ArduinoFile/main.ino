#include "M5Atom.h"

void setup() {
  M5.begin(true, false, true);
  Serial.begin(115200);
  M5.dis.fillpix(0xff0000);
}
void loop() {
  String str = Serial.readString();
  M5.dis.fillpix(0x000000);
  if (str == "jump") {
    M5.dis.fillpix(0x0000ff);
  } else if (str == "blockbreak") {
    M5.dis.fillpix(0x00ff00);
  }else if(str == "chat"){
    M5.dis.fillpix(0x00ffff);
  }
}