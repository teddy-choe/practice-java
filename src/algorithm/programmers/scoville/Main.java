package algorithm.programmers.scoville;

import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 1};
        new Main().solution(scoville, 7);
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleHeap = new PriorityQueue<>(1000000);

        for(int food : scoville) {
            scovilleHeap.add(food);
        }

        int answer = checkScoville(scovilleHeap, K);

        return answer;
    }

    public void mixFoods(PriorityQueue<Integer> scovilleHeap, int first, int second) {
        addNewFood(scovilleHeap, first + second*2);
    }

    public void addNewFood(PriorityQueue<Integer> scovilleHeap, int newFood) {
        scovilleHeap.add(newFood);
    }

    public int checkScoville(PriorityQueue<Integer> scovilleHeap, int K) {
        int count = 0;

        while(scovilleHeap.peek() < K) {
            if (scovilleHeap.size() <= 1) {
                count = -1;
                break;
            }

            mixFoods(scovilleHeap, scovilleHeap.poll(), scovilleHeap.poll());
            count++;
        }

        return count;
    }
}
