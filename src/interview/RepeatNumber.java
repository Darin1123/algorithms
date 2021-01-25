package interview;

import java.util.Arrays;
import java.util.HashMap;

public class RepeatNumber {

    public static int duplicate(int nums[]) {
        if (nums==null||nums.length==0||nums.length==1)
            return -1;
        Arrays.sort(nums);
        int current = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]==current)
                return nums[i];
            else
                current=nums[i];
        }
        return -1;
    }

    public static int duplicate1(int nums[]) {
        if (nums==null||nums.length==0||nums.length==1)
            return -1;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i:nums) {
            if (map.get(i)!=null)
                return i;
            else
                map.put(i, true);
        }
        return -1;
    }

    public static int duplicate2(int nums[]) {
        if (nums==null||nums.length==0||nums.length==1)
            return -1;
        for (int i=0; i<nums.length; i++) {
            int m;
            while ((m=nums[i])!=i) {
                if (nums[m]==m)
                    return m;
                int t = nums[i];
                nums[i] = nums[m];
                nums[m] = t;

            }
        }
        return -1;
    }

    public static int duplicate3(int nums[]) {
        if (nums==null||nums.length==0||nums.length==1)
            return -1;
        return helper(nums, 1, nums.length-1);
    }

    private static int helper(int nums[], int lo, int hi) {
        System.out.println(lo+", "+hi);
        if (lo==hi) return -1;
        int mid = hi/2;
        if (mid<=lo) return -1;
        int left = 0, right = 0;
        for (int i:nums) {
            if ((i >= lo && i <= mid)) {
                left++;
            } else if (i>mid && i<=hi) {
                right++;
            }
        }
        if (left>mid-lo+1)
            return helper(nums, lo, mid);
        if (right>hi-mid)
            return helper(nums, mid+1, hi);
        return -1;
    }

    public static int duplicate4(int nums[]) {
        if (nums==null||nums.length<=1)
            return -1;
        int start = 1;
        int end = nums.length - 1;
        while (end>=start) {
            int middle = ((end-start)/2)+start;
            int count = helper2(nums, start, middle);
            if (end==start) {
                if (count>1)
                    return start;
                else
                    break;
            }

            if (count>(middle-start+1))
                end = middle;
            else
                start = middle+1;
        }
        return -1;
    }

    public static int helper2(int nums[], int start, int end) {
        int count = 0;
        for (int i:nums)
            if (i>=start && i<=end)
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(duplicate4(new int[]{2, 3, 5, 4, 5, 2, 6, 7}));
        HashMap<Integer, Boolean> map = new HashMap<>();
        System.out.println(map.get(2));
    }
}
