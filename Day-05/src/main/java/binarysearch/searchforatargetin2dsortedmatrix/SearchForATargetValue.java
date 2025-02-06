package binarysearch.searchforatargetin2dsortedmatrix;

public class SearchForATargetValue {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 6, 9},
                {10, 11, 18, 20},
                {23, 31, 39, 40}
        };
        int target = 3;
        //call method
        System.out.println(binarySearch(matrix, target));
    }
    //method to search fot target value
    public static boolean binarySearch(int[][] matrix, int target) {
        //if the matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // not found
        return false;
    }
}
