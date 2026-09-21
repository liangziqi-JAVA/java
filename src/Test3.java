import java.util.Scanner;
public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //读入有几个数字
        int n = sc.nextInt();
        //创建一个长度为n的数组，用来存放这n个数字
        int[] arr = new int[n];
        //准备两个变量：记录总和，记录最大值
        int sum = 0;
        int max = 0;
        //先假设最大值为0（注意如果数字全是负数，这里会报错，我们先不考虑这么复杂）
        //循环n次，读入数字，并同时计算
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();   //把读到的数字放进数组
            sum = sum +arr[i];      //累计到总和里
            //如果当前这个数字比max还大，就把max更新为它
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("总和是: " + sum);
        System.out.println("最大值是：" + max);
    }
}
