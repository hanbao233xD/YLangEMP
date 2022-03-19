# EndMinecraftPlus
基于<a href="https://github.com/iuli-moe/EndMinecraft">EndMinecraft</a>优化修改的Minecraft压测工具

配置文件：config.properties

```java
#description
#Fri Mar 11 23:08:35 CST 2022
#名称前缀
name=233
#调试
debug=false
#自定义刷屏
customspam=true
#心跳包
tab=true
#端口
port=25565
#代理类型
proxies=http.txt
#刷屏延迟
delay=10
#自定义刷屏内容
custommessage=Join ZeroPixel and get MVP++ by free at mc.zeropixel.top
#只有2
mode=2
#ip
ip=mc.yuanpi.xyz
#代理类型
pxtype=http
#自动识别authme验证码
captcha=true
#乐乐
lele=false
#刷屏
spam=true
#刷屏延迟
spamdelay=5000

```



*支持*

1.自动注册

2.自动识别验证码（某些服务器）

3. 自定义刷屏
4. 选择代理类型
5. 从本地载入配置

*修改内容:*
1.重构大量核心代码
2.大幅度性能优化
3.修复Forge协议无法进服
4.修复AntiCheat特定情况无法进服
5.增加AntiCheat自定义MD5
6.移除部分过时功能
