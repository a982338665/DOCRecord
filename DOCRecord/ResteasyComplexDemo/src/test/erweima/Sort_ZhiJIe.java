package test.erweima;

public class Sort_ZhiJIe {

    public static void directSort(int[] arr) {  
        
    int waitInsert;         //等待插入的数  
    int i,j;            //i表示当前待插入数下标；j表示本次被比较的有序数位置  
      
    for(i = 1; i < arr.length; i++) {  
        waitInsert = arr[i];    //得到本轮待插入的数  
        j = i - 1;      //比较位置初始化，也就是有序序列的最后一个位置，从后往前  
          
        //若大于或等于等待插入的数值大小，则该数右移，然后进行下一次比较  
        while(j > -1 && arr[j] >= waitInsert) {  
            arr[j + 1] = arr[j];  
            j--;  
        }  
        //插入的位置一定是上一次比较的数的位置，也就是j+1的位置。（注意到j--的时机即可理解）  
        arr[j + 1] = waitInsert;  
    }  
}  
    public static void main(String[] args) {
   	 int c []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
   	directSort(c);
   	 for (int i : c) {
			System.out.print(i+" ");
		}
}
}