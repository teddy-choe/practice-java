package algorithm.programmers.bad_users;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution.solution(userId, bannedId));
    }

    boolean[] visited;
    int result = 0;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        backTracking(user_id, banned_id, 0, 0);

        return result;
    }

    public void backTracking(String[] user_id, String[] banned_id, int index, int count) {
        if (count == banned_id.length) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    list.add(user_id[i]);
                }
            }

            boolean[] checked = new boolean[banned_id.length];
            for (String userId : list) {
                for (int i=0; i< banned_id.length; i++) {
                    if (checked[i]) continue;

                    if (checkValidIdToBan(userId, banned_id[i])) {
                        checked[i] = true;
                        break;
                    }
                }
            }

            for (int i=0; i< checked.length; i++) {
                if (!checked[i]) return;
            }

            result++;
            return;
        }

        for (int i = index; i < user_id.length; i++) {
            visited[i] = true;
            backTracking(user_id, banned_id, i + 1, count + 1);
            visited[i] = false;
        }
    }

    public boolean checkValidIdToBan(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }

            if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
