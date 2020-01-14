package compare;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

/**
 * 判断版本大小
 *
 * @author town
 * @Date 2019/11/28
 */
public class CompareVersion {

    /**
     * @param v1 version1
     * @param v2 version2
     * @return 1:v1>v2 0:v1=v2 -1:v1<v2
     */
    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }

        int index;
        long diff = 0;
        String[] version1Array = v1.split("[._-]");
        String[] version2Array = v2.split("[._-]");
        for (index = 0; index < min(version1Array.length, version2Array.length); index++) {
            diff = toInt(version1Array[index]) - toInt(version2Array[index]);
            if (diff != 0) {
                return diff > 0 ? 1 : -1;
            }
        }

        for (int i = index; i < version1Array.length; i++) {
            if (toInt(version1Array[i]) > 0) {
                return 1;
            }
        }
        for (int i = index; i < version2Array.length; i++) {
            if (toInt(version2Array[i]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * @param str 待转换字符串
     * @return 去掉多余字符整数
     */
    private static int toInt(String str) {
        int result = 0;
        String reg = "[^0-9]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(0 + str);
        result = Integer.parseInt(matcher.replaceAll("").trim());

        return result;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("2.1.3.10.1.1", "2.1.3.11.1"));
    }
}