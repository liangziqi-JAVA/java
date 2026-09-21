public class TestMin {
    public static void main(String[] args){
        int[] arr = {3,1,2,3};
        int min = getMin(arr);
        System.out.println("最小值是：" + min);
    }
    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
             min = arr[i];
            }
        }
        return min;
    }
}
