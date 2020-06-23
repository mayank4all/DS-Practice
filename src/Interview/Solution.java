package Interview;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,5,4,8,6,7,9};
        // {6,2,8,4,5,1,7,9}
        evenOdd1(arr);
        // Desired - [2,4,8,6,1,5,7,9]
    }

    public static void evenOdd(int[] arr){
        int left=0, right=arr.length-1;
        while(left<right){
            while(arr[left]%2==0 && left<right){
                left++;
            }
            while(arr[right]%2==1 && left<right){
                right--;
            }
            if (left < right) {
                int t = arr[left];
                arr[left]=arr[right];
                arr[right]=arr[left];
                left++;
                right--;
            }
        }
    }

    public static void evenOdd1(int[] arr){
        int odd=-1,even=0;
        while(even!=arr.length){
            if(arr[even]%2 == 0){
                odd++;
                int tmp = arr[odd];
                arr[odd] = arr[even];
                arr[even] = tmp;
            }
            even++;
        }
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
    }

}
