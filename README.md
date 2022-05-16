# EndMinecraftPlus
基于<a href="https://github.com/iuli-moe/EndMinecraft">EndMinecraft</a>优化修改的Minecraft压测工具

[![State-of-the-art Shitcode](https://img.shields.io/static/v1?label=State-of-the-art&message=Shitcode&color=7B5804)](https://github.com/trekhleb/state-of-the-art-shitcode)

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
#代理文件
proxies=http.txt
#刷屏延迟
delay=10
#自定义刷屏内容
custommessage=Join ZeroPixel and get MVP++ by free at mc.zeropixel.top
#只有2
mode=2
#ip
ip=mc.mini1.club
#代理类型
pxtype=http
#自动识别authme验证码
captcha=true
#authme验证码长度
authmelength
#在攻击前请求motd，以绕过老版本AntiAttack
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
2.大幅度性能负优化
3.修复Forge协议无法进服
