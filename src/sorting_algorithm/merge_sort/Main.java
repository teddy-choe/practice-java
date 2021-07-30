package sorting_algorithm.merge_sort;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] array = {1,5,3,2,6,8,4};

        for (int num : array) {
            System.out.print(num + ", ");
        }

        System.out.println();
        main.mergeSort(array, 0, array.length-1);

        for (int num : array) {
            System.out.print(num + ", ");
        }

    }

    void mergeSort(int[] originArray, int start, int end) {
        if (start == end) return;

        int mid = (start + end) / 2;
        mergeSort(originArray, start, mid);
        mergeSort(originArray, mid+1, end);
        merge(originArray, start, end);
    }

    void merge(int[] originArray, int start, int end) {
        int[] sortedArray = new int[originArray.length];
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = left;

        while (left <= mid && right <= end) {
            if (originArray[left] <= originArray[right]) {
                sortedArray[index++] = originArray[left];
                left++;
            } else {
                sortedArray[index++] = originArray[right];
                right++;
            }
        }

        while (left <= mid) {
            sortedArray[index++] = originArray[left++];
        }

        while (right <= end) {
            sortedArray[index++] = originArray[right++];
        }

        for (int i=start; i<=end; i++) {
            originArray[i] = sortedArray[i];
        }
    }
}
