package pers.li;

/**
 * create by lishengbo on 2018-04-20 11:20
 *
 * 基本数据类型转换为二进制数据
 * 字符串转换为byte
 *
 */
public class Convert
{


    /**
     * int --> byte 1个int占4个字节
     * @param id
     * @return
     */
    public static byte[] int2Bytes(int id){
        byte[] arr=new byte[4];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(byte)((int)(id>>i*8)&0xff);
        }
        return arr;
    }



    /**
     *  byte --> int  1个int占4个字节
     * @param arr
     * @return
     */
    public static int bytes2int(byte[] arr){
        int rs=0;
        for (int i = 0; i <arr.length ; i++) {
           rs+=(int)(arr[i]&0xff)<<i*8;
        }
        return rs;
    }


    public static void main(String[] args) {
        //
        System.out.println(int2Bytes(8143)[0]+"|"+int2Bytes(8143)[1]+"|"+int2Bytes(8143)[2]+"|"+int2Bytes(8143)[3]);
        byte[] b=new byte[4];
        b[0]=-49;
        b[1]=31;
        b[2]=0;
        b[3]=0;
        System.out.println(bytes2int(b));
    }
}
