package quick_sort;

public class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void sort(int start, int end) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();

        if (start!=end) {
            int mid = partition(start, end);
            sort(start, mid-1);
            sort(mid+1, end);
        } else return;
    }


    //FIXME: start, end가 같은 값일때 버그 발생. 아얘 start++, end++가 되지 않아서 종료되지않는다.
    private int partition(int start, int end) {
        int pivot = (start+end)/2;

        while(start<end) {
                while (array[start] < array[pivot]) start++;
                while (array[end] > array[pivot]) end--;

                if (end == pivot) {
                    pivot = start;
                } else if (start == pivot) {
                    pivot = end;
                }

                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
        }

        return pivot;
    }
}
