package interview;

public class FindNumFrom2DArray {
    public static boolean contains(int nums[][], int target) {
        if (nums==null) return false;
        int rows = nums.length;
        if (rows==0) return false;
        int columns = nums[0].length;
        if (columns==0) return false;
        int r = 0, c = columns-1;
        while (r<rows && columns>0) {
            int current = nums[r][c];
            if (current==target)
                return true;
            if (current>target)
                c--;
            else
                r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {3, 8, 10, 13},
                {7, 10, 11, 15}
        };
        System.out.println(contains(test, 7));
    }
}
