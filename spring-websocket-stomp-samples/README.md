# spring-websocket-stomp-samples
a springboot websocket stomp samples

#### 1. 启动项目

#### 2. 打开 http://localhost:8080/stompSocket.do
将以上地址在两个页面中打开

#### 3. 在 console 中获取每个客户端对应的user-name
```
<<< CONNECTED
version:1.1
heart-beat:10000,10000
user-name:508371ED4E3456675E0F12152CDADCFC
```
这里的 user-name 就是输入框中对用的接收人

#### 4. 然后在页面上填写填写接收人的 user-name，并且填写消息然后点击点对点消息，即可给指定接收人发送消息
