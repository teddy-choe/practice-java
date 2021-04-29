package algorithm.word_transform;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution.solution(begin, target, words));
    }

    static class Solution {
        int totalCount = Integer.MAX_VALUE;

        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            boolean[] visited = new boolean[words.length];

            boolean isContainTarget = false;

            for(String word: words) {
                if(word.equals(target)) {
                    isContainTarget = true;
                }
            }

            if(!isContainTarget) {
                return 0;
            }

            dfs(target, words, begin, 0, visited);
            answer = totalCount;

            return answer;
        }

        public void dfs(String target, String[] words, String curWord, int count, boolean[] visited) {
            if(curWord.equals(target)) {
                if(totalCount > count) {
                    totalCount = count;
                }

                return;
            }

            for(int i=0; i<words.length; i++) {
                if(!visited[i] && checkEnableWord(curWord, words[i])) {
                    visited[i] = true;
                    dfs(target, words, words[i], count + 1, visited);
                    visited[i] = false;
                }
            }
        }

        public boolean checkEnableWord(String curWord, String toTransformWord) {
            int n = curWord.length();
            boolean differentWord = false;

            for(int i=0; i<n; i++) {
                if(curWord.charAt(i) != toTransformWord.charAt(i)) {
                    if(differentWord) {
                        return false;
                    }

                    differentWord = true;
                }
            }

            return true;
        }
    }
}
