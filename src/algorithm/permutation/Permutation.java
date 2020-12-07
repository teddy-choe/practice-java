package algorithm.permutation;

public class Permutation {
    public void permute(char[] array, int start, int end) {
        if (start == end) {
            for (char c: array) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        for (int i=start; i<=end; i++) {
            swap(array, start, i);
            permute(array, start+1, end);
            swap(array, start, i);
        }
    }

    private void swap(char[] array, int preIndex, int postIndex) {
        // 인자로 넘어온 array와 바깥의 array가 같은 스택에 있는 변수인가?
        char temp = array[preIndex];
        array[preIndex] = array[postIndex];
        array[postIndex] = temp;
    }
}