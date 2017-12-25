package pers.lish.girl.aoplearning.dynamicproxy_modle.recursion;

/**
 * create by lishengbo on 2017-12-25 10:02
 * 递归算法
 */
public class RecursionAlgorithmTest {

    /***
     * 1列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是多少
     * x指要得到第几位数的值
     */
    public  static int getNum(int x){
        if(x<1){
            return 0;
        }else if(x==1){
            return 1;
        }else if(x==2){
            return 2;
        }else{
            return getNum(x-1)+getNum(x-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNum(4));
        System.out.println(calSum(4));

    }

    private static int sum=0,num=1;
    public static int calSum(int maxnum){
        if(num<=maxnum){
            sum+=num;
            num++;
            calSum(maxnum);
        }
        return sum;
    }

}
