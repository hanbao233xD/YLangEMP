# EndMinecraftPlus
基于<a href="https://github.com/iuli-moe/EndMinecraft">EndMinecraft</a>优化修改的Minecraft压测工具

配置文件：config.properties

```java
#description
#Fri Mar 11 23:08:35 CST 2022
customspam=true #自定义刷屏
name=NMSL #名称前缀
debug=false #调试模式（输出聊天发送接收）
port=25565 #废话
tab=true #怎么说呢 开就对了
proxies=http.txt #代理文件
delay=10 #加入延迟
custommessage=duke i love u #自定义刷屏内容
mode=2 #模式 2就对了
pxtype=http #http/socks
ip=mc.yuanpi.xyz #废话
lele=false #超市乐乐(idk)
spam=true #刷屏
auto=true #不用管

```



*支持*

1.自动注册

2.自动识别验证码（某些服务器）

3. 自定义刷屏
4. 选择代理类型
5. 从本地载入配置
6. 送给某人的第二份礼物❤

*修改内容:*
1.重构大量核心代码
2.大幅度性能优化
3.修复Forge协议无法进服
4.修复AntiCheat特定情况无法进服
5.增加AntiCheat自定义MD5
6.移除部分过时功能
