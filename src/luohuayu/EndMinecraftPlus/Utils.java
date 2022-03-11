package luohuayu.EndMinecraftPlus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static void log(String from, Object msg) {
		System.out.println("[" + from + "] " + msg);
	}

	public static void log(Object msg) {
		System.out.println(msg);
	}

	public static void log(Object... msg) {
		for (Object o : msg) {
			System.out.println(o);
		}
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Matcher matches(String str, String regex) {
		Pattern mPattern = Pattern.compile(regex);
		Matcher mMatcher = mPattern.matcher(str);
		return mMatcher;
	}

	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log("HTTP", "HTTP请求失败: " + e.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				log("HTTP", "IO异常: " + e.getMessage());
			}
		}
		return result;
	}

	public static String getRandomString(int minLength, int maxLength) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		int length = random.nextInt(maxLength) % (maxLength - minLength + 1) + minLength;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T getCo(String date, T def) {
		if (date.equals("")) {
			return def;
		}
		return (T) date;
	}

	public static int getCo(String date, int def) {
		if (date.equals("")) {
			return def;
		}
		return Integer.parseInt(date);
	}

	public static String getcode(int getnum, String cmd) {
		String code = cmd.substring(cmd.length() - getnum, cmd.length());
		return code.toString();
	}

	public static String getclnmsl() {
		String msg = getsingleString("啥杀沙莎砂纱", 6) + getsingleString("比必币笔毕碧", 6) + getsingleString("参惨蚕灿惭餐", 6)
				+ getsingleString("楞愣堎棱", 4) + getsingleString("尼拟妮泥倪逆", 6) + getsingleString("吗骂码嘛马玛", 6)
				+ getsingleString("四思斯司丝似", 6) + getsingleString("了乐勒辣啦", 5) + getsingleString("是事市匙世式视", 7)
				+ getsingleString("不布部步捕补埠", 7) + getsingleString("是事市匙世式视", 7);
		return msg.toString();
	}

	public static String getsingleString(String list, int num) {
		String str = list;
		Random random = new Random();
		int length = random.nextInt(1) % (1 - 1 + 1) + 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(num);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	public static String gsp() {
		String str = getsingleString(
				"网站发布广告设计制作代理发布广告货物进出口技术进出口代理进出口医疗软件技术开发委托生产电子产品玩具照相器材销售家用电器机械设备五金交电不含电动自行车电子产品文化用品照相器材计算机软件及辅助设备化妆品卫生用品体育用品纺织品服装鞋帽日用品家具首饰避孕器具工艺品钟表眼镜玩具汽车及摩托车配件仪器仪表塑料制品花草及观赏植物建筑材料通讯设备汽车电子产品器件和元件自行开发后的产品预防保健咨询公园门票文艺演出体育赛事展览会票务代理翻译服务通讯设备和电子产品的技术开发计算机系统服务车联网技术开发汽车电子产品设计研发制造北京市中心城区除外演出经纪人才中介服经营电信业务利用信息网络经营音乐娱乐产品演出剧节目动漫产品游戏产品含网络游戏虚拟货币发行表演网络游戏技法展示或解说网络文化经营许可证有效期至年月日因特网信息服务业务除出版教育医疗保健以外的内容图书电子出版物音像制品批发零售网上销售。市场主体依法自主选择经营项目开展经营活动演出经纪人才中介服务利用信息网络经营音乐娱乐产品演出剧节目动漫产品游戏产品含网络游戏虚拟货币发行表演网络游戏技法展示或解说经营电信业务以及依法须经批准的项目经相关部门批准后依批准的内容开展经营活动不得从事国家和本市产业政策禁止和限制类项目的经营活动",
				530);
		return str;
	}

	public static String getchar() {
		String str = getsingleString(",.;_，。->", 8);
		return str;
	}

}
