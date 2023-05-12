# Minecraft-AtomLiteLED
- - -
Minecraft内の特定動作を検知し、Atom-Liteの付属のLEDを光らせる。
## 開発環境
- Arduino IDEA Ver 2.1.0
- IntelliJ IDEA Ver 2023.1.1
### 開発言語
- Java
- Arduino
### 実装環境
- Minecraft ver 1.19.4
- Paper MC Ver 1.19.4-SnapShot

# 仕様
シリアル通信を用いて、MinecraftPluginからM5Stack Atom-Liteに特定の文字列を送信し、文字列に応じてLEDの色を点灯させる。
