package algorithm.search_2d_matrix;

public class Main {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;

        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == target) {
                result = true;
                break;
            }

            if (matrix[i][0] > target) {
                break;
            }

            if (binarySearch(matrix[i], target)) {
                result = true;
            }
        }

        return result;
    }

    public boolean binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
