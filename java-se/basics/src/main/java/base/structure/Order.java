package base.structure;

/**
 * Created by Administrator on 2017/5/24.
 * 冒泡排序
 */
public class Order {
    public static void main(String[] args) {
        int[] arr={4,44,12,452,35,11,34,632,52,52,12,43};
        boolean isSort=true;
        for (int i = 0; i <arr.length ; i++) {
            for (int j=arr.length-1;j>i;j--){
                if (arr[j]>arr[j-1]){
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                    isSort=false;
                }
            }
            if (isSort){
                break;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if (i!=0) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }


        //////////////////////////////插入排序//////////////////////////
        Integer[] x = { 21, 4, 1, 54, 76, 3, 45, 1, 65, 223, 0 };
        paixu(x);
        for (int i = 0; i < x.length; i++) {
            if (i!=0) {
                System.out.print(",");
            }
            System.out.print(x[i]);
        }
    }

    /**插入排序
     * 对数组进行排序
     */
    public static void paixu(Integer[] o) {
        for (int i = 0; i < o.length; i++) {
            // 将i取出来，存储起来
            Integer in = o[i];
            int y = i - 1;// 将下标移至到前一位
            while (y >= 0 && in < o[y]) {
                o[y + 1] = o[y];// 将位置向后移动一位
                y--;// 将下标减1，再进行比较，如果小于就将大于它的下标向后移
            }
            o[y + 1] = in;// 将值复制给空出来的那个值
        }
    }

    /**
     * 选择排序
     */
    public void xuanze() {
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
            if (i!=0) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
    }
}
