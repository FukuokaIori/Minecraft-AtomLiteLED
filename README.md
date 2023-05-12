# Minecraft-AtomLiteLED
- - -
Minecraft内の特定動作を検知し、Atom-Liteの付属のLEDを光らせる。
## 開発環境
- Paper MC version 1.19.4-SnapShot
- 17 Oracle OpenJDK version 17.0.7
- jSerialComm version 2.0~3.0
- M5Stack Atom-Lite
### 開発言語
- Java
- Arduino

# 仕様
シリアル通信を用いて、MinecraftPluginからM5Stack Atom-Liteに特定の文字列を送信し、文字列に応じてLEDの色を点灯させる。
