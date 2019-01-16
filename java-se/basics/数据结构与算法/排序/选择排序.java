package 排序;


/**
 * Created by Administrator on 2017/5/24.
 */
public class 选择排序 {
    public static void main(String[] args) {
        Integer[] arr = { -123,234,123,43,25,26,21, 4, 1, 54, 76, 3, 45, 1, 65, 223, 0 };
        for (int i = 0; i < arr.length; i++) {
            int sIndex=i;// 用一个变量储存最小值得下标
            int sNumber=arr[sIndex];// 用一个值记录最小值
            int j=i+1;// 与后面的比较找出最小值
            while(j<arr.length){
                if (arr[j]<sNumber){
                    sNumber=arr[j];// 比当前小的值记录下来，当最小的值
                    sIndex=j;// 把下标记录下来
                }
                j++;// 下标徃后移
            }
            arr[sIndex]=arr[i];
            arr[i]=sNumber;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i!=0)
                System.out.print(",");
            System.out.print(arr[i]);
        }
    }
}
