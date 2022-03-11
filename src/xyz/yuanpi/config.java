package xyz.yuanpi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
    private static Properties propertie;
    private static FileInputStream inputFile;
    private static FileOutputStream outputFile;

    /**
     * 初始化loadcfg类
     */
    public config() {
        propertie = new Properties();
    }

    /**
     * 初始化loadcfg类
     * 
     * @param filePath 要读取的配置文件的路径+名称
     * @return
     */
    public static void readconfig(String filePath) {
        propertie = new Properties();
        try {
            inputFile = new FileInputStream(filePath);
            propertie.load(inputFile);
            inputFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("装载文件--->失败!");
            ex.printStackTrace();
        }
    }// end ReadConfigInfo(...)

    /**
     * 重载函数，得到key的值
     * 
     * @param key 取得其值的键
     * @return key的值
     */
    public static String getValue(String key) {
        if (propertie.containsKey(key)) {
            String value = propertie.getProperty(key);// 得到某一属性的值
            return value;
        } else
            return "";
    }// end getValue(...)

    /**
     * 重载函数，得到key的值
     * 
     * @param fileName properties文件的路径+文件名
     * @param key      取得其值的键
     * @return key的值
     */
    public String getValue(String fileName, String key) {
        try {
            String value = "";
            inputFile = new FileInputStream(fileName);
            propertie.load(inputFile);
            inputFile.close();
            if (propertie.containsKey(key)) {
                value = propertie.getProperty(key);
                return value;
            } else
                return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }// end getValue(...)

    /**
     * 清除properties文件中所有的key和其值
     */
    public void clear() {
        propertie.clear();
    }// end clear();

    /**
     * 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替，
     * 当key不存在时，该key的值是value
     * 
     * @param key   要存入的键
     * @param value 要存入的值
     */
    public static void setValue(String key, String value) {
        propertie.setProperty(key, value);
    }// end setValue(...)

    /**
     * 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。
     * 
     * @param fileName    文件路径+文件名称
     * @param description 对该文件的描述
     */
    public static void saveFile(String fileName, String description) {
        try {
            outputFile = new FileOutputStream(fileName);
            propertie.store(outputFile, description);
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }// end saveFile(...)

    public static boolean getBoolean(String key) {
        return getBoolean(propertie, key, false);
    }

    /**
     * 获取布尔型属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

    public static int toint(String str) {
        int b = Integer.valueOf(str).intValue();
        return b;
    }

}
