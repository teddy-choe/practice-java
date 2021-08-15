package java_practice.sorted_array_merge;

public class Main {
    public static void main(String[] args) {
        int[] list1 = {1,4,5,7,10,0,0,0,0};
        int[] list2 = {2,3,4,8};

        sort(list1, list2);

        for (int i: list1) {
            System.out.println(i);
        }
    }

    private static void sort(int[] list1, int[] list2) {
        int index = 0;
        int oneIndex = 0;
        int twoIndex = 0;

        int oneSize = 0;
        int temp = 0;

        while (true) {
            if (list1[temp] == 0) {
                oneSize = temp;
                break;
            }

            temp++;
        }

        while (oneIndex <= oneSize && twoIndex < list2.length) {
            if (list1[oneIndex] < list2[twoIndex]) {
                oneIndex++;
                index++;
            } else {
                for (int i=list1.length-1; i>oneIndex; i--) {
                    list1[i] = list1[i-1];
                }

                list1[index] = list2[twoIndex];
                index++;
                oneIndex++;
                twoIndex++;
            }
        }

        if (twoIndex < list2.length) {
            while (twoIndex < list2.length) {
                list1[index++] = list2[twoIndex++];
            }
        }
    }
}
