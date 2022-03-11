package luohuayu.EndMinecraftPlus.proxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import luohuayu.EndMinecraftPlus.Utils;

public class ProxyPool {
	public static List<String> proxys = new ArrayList<String>();

	public static void getProxysFromFile(String filename) {
		try {
			File file = new File(filename);
			if (!file.exists())
				return;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				proxys.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Utils.log("Proxy", "从本地读取代理完成!数量:" + proxys.size());
	}

	public static void runUpdateProxysTask(final int time) {
		new Thread(() -> {
			while (true) {
				Utils.sleep(time * 1000);
				synchronized (proxys) {
					proxys.clear();
				}
			}
		}).start();
	}
}
