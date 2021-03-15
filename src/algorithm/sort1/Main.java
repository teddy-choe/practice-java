package algorithm.sort1;

// 정렬 된 두 배열이 주어질 때, 정렬된 상태로 병합을 하는 알고리즘
public class Main {
    public static void main(String[] args) {
        int[] firstArray = {1,2,5,6,7};
        int[] secondArray = {4,6,7,8,9};

        int[] resultArray = new int[firstArray.length + secondArray.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        // first 배열, second 배열 모두 거의 다 돌아야하는 상황이 최악이다. 이 때 O{n^2}이다
        while(firstIndex < firstArray.length && secondIndex < secondArray.length) {
            if (firstArray[firstIndex] <= secondArray[secondIndex]) {
                resultArray[resultIndex++] = firstArray[firstIndex++];
            } else {
                resultArray[resultIndex++] = secondArray[secondIndex++];
            }
        }

        if (firstIndex >= firstArray.length) {
            while(secondIndex < secondArray.length) {
                resultArray[resultIndex++] = secondArray[secondIndex++];
            }
        } else {
            while(firstIndex < firstArray.length) {
                resultArray[resultIndex++] = firstArray[firstIndex++];
            }
        }

        for (int result : resultArray) {
            System.out.print(result + ", ");
        }
    }
}
