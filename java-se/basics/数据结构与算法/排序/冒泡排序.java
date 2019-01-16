package 排序;

/**
 * Created by Administrator on 2017/5/24.
 * 冒泡排序
 */
public class 冒泡排序 {
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
            if (i!=0)
                System.out.print(",");
            System.out.print(arr[i]);
        }
    }
}
