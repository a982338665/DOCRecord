package test.erweima;

public class SeachKey_IntArray {

	   /** 
     * 使用递归的二分查找 
     *title:recursionBinarySearch 
     *@param arr 有序数组 
     *@param key 待查找关键字 
     *@return 找到的位置 
     */  
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){  
          
        if(key < arr[low] || key > arr[high] || low > high){  
            return -1;                
        }  
          
        int middle = (low + high) >>> 1;          //初始中间位置  
        if(arr[middle] > key){  
            //比关键字大则关键字在左区域  
            return recursionBinarySearch(arr, key, low, middle - 1);  
        }else if(arr[middle] < key){  
            //比关键字小则关键字在右区域  
            return recursionBinarySearch(arr, key, middle + 1, high);  
        }else {  
            return middle;  
        }     
          
    }  
    
    
    
    
   // 方法二：
        /** 
     * 不使用递归的二分查找 
     *title:commonBinarySearch 
     *@param arr 
     *@param key 
     *@return 关键字位置 
     */  
    public static int commonBinarySearch(int[] arr,int key){  
        int low = 0;  
        int high = arr.length - 1;  
        int middle = 0;         //定义middle  
          
        if(key < arr[low] || key > arr[high] || low > high){  
            return -1;                
        }  
          
        while(low <= high){  
            middle = (low + high) >>> 1;  
            if(arr[middle] > key){  
                //比关键字大则关键字在左区域  
                high = middle - 1;  
            }else if(arr[middle] < key){  
                //比关键字小则关键字在右区域  
                low = middle + 1;  
            }else{  
                return middle;  
            }  
        }  
          
        return -1;      //最后仍然没有找到，则返回-1  
} 
    public static void main(String[] args) {
   	 int c []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
     System.out.println(commonBinarySearch(c,49));;
	}
}
