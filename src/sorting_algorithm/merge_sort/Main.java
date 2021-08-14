package sorting_algorithm.merge_sort;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] array = {1,5,3,2,6,8,4};

        for (int num : array) {
            System.out.print(num + ", ");
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);

        System.out.println();

        for (int num : array) {
            System.out.print(num + ", ");
        }

    }
}
