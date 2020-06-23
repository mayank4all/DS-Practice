public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums,5));
    }

        public static int search(int[] nums, int target) {
            if(nums.length==0){return -1;}
            if(nums.length==1 && nums[0]!=target){return -1;}
            if(nums[0]==target){return 0;}

            int minIdx = findMinIdx(nums);
            if (target == nums[minIdx]) return minIdx;
            int m = nums.length;
            int start = (target <= nums[m - 1]) ? minIdx : 0;
            int end = (target > nums[m - 1]) ? minIdx : m - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) return mid;
                else if (target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
            return -1;
        }

        public static int findMinIdx(int[] nums) {
            int start = 0, end = nums.length - 1;
            while (start < end) {
                int mid = start + (end -  start) / 2;
                if (nums[mid] > nums[end]) start = mid + 1;
                else end = mid;
            }
            return start;
        }
}
