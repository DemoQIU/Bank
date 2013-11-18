package itstudio.bank.utils;
/**
 * 此类用于md5 加密。由于md5 加密网上有破解的办法下面做了修改
 */
import java.security.MessageDigest;
public class MD5Util {
    public final static String MD5(String name) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'A', 'B', 'C', 'D', 'E', 'F' };
        try {
        	// 此处修改了md5 加密防止破解
            byte[] btInput = (name+"8ef").getBytes();
     //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
     //使用指定的字节更新摘要
            mdInst.update(btInput);
     //获得密文
            byte[] md = mdInst.digest();
     //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}