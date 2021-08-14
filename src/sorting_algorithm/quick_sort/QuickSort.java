package sorting_algorithm.quick_sort;

/*
 * 왼쪽 피벗은 오른쪽 포인터부터 내려와야한다. 왜??
 * 오른쪽 피벗은 반대임 왜?
 */

public class QuickSort {
    public int[] sort(int[] list) {
        sort(list, 0, list.length-1);

        return list;
    }

    private void sort(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = leftPartition(list, start, end);

        sort(list, start, mid-1);
        sort(list, mid+1, end);
    }

    private int leftPartition(int[] list, int start, int end) {
        int pivot = start;
        int left = start;
        int right = end;

        while (left < right) {
            // pivot보다 작거나 같은 값을 찾는다
            while (left < right && list[pivot] < list[right]) {
                right--;
            }

            // pivot보다 큰 값을 찾는다
            while (left < right && list[pivot] >= list[left]) {
                left++;
            }

            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }

        int temp = list[pivot];
        list[pivot] = list[left];
        list[left] = temp;

        return left;
    }

    private int middlePartition(int[] list, int start, int end) {
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;

        while (left < right) {
            // 왼쪽에서부터 피봇보다 큰 값을 찾는다
            while (left < right && list[pivot] >= list[left]) {
                left++;
            }

            // 오른쪽부터 피봇보다 작거나 같은 값을 찾는다
            while (left < right && list[pivot] < list[right]) {
                right--;
            }

            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }

        return pivot;
    }

}
