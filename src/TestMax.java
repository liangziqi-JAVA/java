import java.util.Scanner;
public class TestMax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想输入的几个数字");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入"+ n + "个整数");
        for (int i = 0; i < n; i++){
            arr[i] =sc.nextInt();
        }
        int max = getMax(arr);
        System.out.println("你输入的最大值是：" + max);
    }
    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length; i++){
            if (arr[i] >max){
                max = arr[i];
            }
        }
        return max;
    }
}
