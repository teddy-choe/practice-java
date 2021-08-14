package sorting_algorithm.quick_sort;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,1,2,3,4,6,7,8,9,10};

        QuickSort quickSort = new QuickSort();

        quickSort.sort(array);

        for (int i: array) {
            System.out.println(i);
        }
    }
}
