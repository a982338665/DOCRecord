package pers.li;

/**
 * create by lishengbo on 2018-04-17 14:30
 * 进制：方便运算的计数系统--8,16,60,20,10等进制
 * 二进制：满二进一 基本数字：0和1
 * 十进制：满十进一 基本数字：0-9
 * 位权：所在位置的不同表示的意义不同
 * **********************************
 * 八进制：适用于12位和36位计算机系统，标志的开头以0表示 用0-7表示  满8进一
 * 16进制：用0-9，A-F共16位表示，表达长度短，常用，标志开头以0x表示 满16进一
 */
public class erjinzhi {

    public static void main(String[] args) {
        int i = to10("111021");
        System.out.println(i);
        System.out.println(to2(5));
        System.out.println(to8(160000));
    }

    /**
     * 二进制转化为十进制
     * s只能为数字并且只能用0,1表示
     * 如 111001
     * 转换为：
     * 2^5+2^4+2^3+2^0=57
     * 所有占位为1的地方均表示为：
     * 下标为从右到左的第几位，下标从o开始，所以在最后一位表示为2的0次方
     */
    public static int to10(String s) {
        int x = 0;
        int length = s.length();
        char[] split = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (split[i] != '1' || split[i] != '0') {
                return -1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (split[i] == '1') {
                x += Math.pow(2, length - i - 1);
            }
        }
        return x;
    }

    /**
     * 十进制转换为二进制
     * s只能为数字并且只能用0,1表示
     * 如 111001
     * 转换为：
     * 2^5+2^4+2^3+2^0=57
     * 所有占位为1的地方均表示为：
     * 下标为从右到左的第几位，下标从o开始，所以在后一位表示为2的0次方
     */
    public static String to2(int s) {
        return conversion(s,2);
    }


    /**
     * 十进制转换为8进制 ：同二进制转换，整除8，逆序
     * 用0-7表示，满8进一
     */
    public static String to8(int s) {
        return conversion(s,8);
    }




    private static String conversion(int s,int type) {
        StringBuilder stringBuilder = new StringBuilder();
        int shang = s;
        int yu = s;
        while (true) {
            yu = shang % type;
            shang = shang / type;
            stringBuilder.append(yu);
            if (shang == 0) {
                break;
            }

        }
        return stringBuilder.reverse().toString();
    }
}
