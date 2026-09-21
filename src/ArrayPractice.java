import java.util.Scanner;
public class ArrayPractice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("请输入10个整数：");
        for (int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("最大值：" + getMax(arr));
        System.out.println("最小值：" + getMin(arr));
        System.out.println("平均值：" + getAvg(arr));
    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
    public static int getMin(int[] arr){
        int min = arr[0];
        for (int i =1 ; i < arr.length; i++){
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }
    public static double getAvg(int[] arr){
        int sum = 0;
        for (int x : arr) sum += x;
        return  sum * 1.0 / arr.length;
    }
}
