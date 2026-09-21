import java.util.Scanner;
public class Test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (x < min){
                min = x;
            }
        }
        System.out.println(min);
    }
}