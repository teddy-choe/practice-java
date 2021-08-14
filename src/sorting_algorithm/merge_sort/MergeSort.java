package sorting_algorithm.merge_sort;

public class MergeSort {
    private int[] sorted;

    public void mergeSort(int[] list) {
        sorted = new int[list.length];
        sort(list, 0, list.length-1);
    }

    private void sort(int[] list, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(list, start, mid);
        sort(list, mid + 1, end);
        merge(list, start, end);
    }

    private void merge(int[] list, int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (list[left] < list[right]) {
                sorted[index] = list[left++];
            } else {
                sorted[index] = list[right++];
            }

            index++;
        }

        if (left <= mid) {
            while (left <= mid) {
                sorted[index++] = list[left++];
            }
        } else {
            while (right <= end) {
                sorted[index++] = list[right++];
            }
        }

        index = start;

        while (index <= end) {
            list[index] = sorted[index];
            index++;
        }
    }
}
