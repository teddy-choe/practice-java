package sorting_algorithm.quick_sort;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 2, 5, 6, 1};

        QuickSort quickSort = new QuickSort(array);

        quickSort.sort(0, 6);
    }
}
