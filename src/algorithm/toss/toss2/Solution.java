package algorithm.toss.toss2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"abc://example.com/path/data"};
        String[] result = solution.solution(input);

        for (String r : result) {
            System.out.println(r);
        }
    }

    // 이 함수는 수정하지 마세요.
    public String[] solution(String[] data) {
        return Arrays.stream(data).map(input -> {
            return parse(input).toString();
        }).toArray(String[]::new);
    }

    // 이 함수를 구현해주세요.
    public Uri parse(String input) {
        String scheme = "";
        String host = "";
        String path = "";
        String queryString = "";
        HashMap<String, String> queryMap = new HashMap();

        String[] schemeSplit = input.split("://");
        scheme = schemeSplit[0];

        int pathIndex = schemeSplit[1].indexOf("/");
        int queryIndex = schemeSplit[1].indexOf("?");

        if (pathIndex == -1 && queryIndex == -1) {
            // 둘 다 없는 경우
            host = schemeSplit[1];
        } else if (pathIndex != -1 && queryIndex == -1) {
            // path만 있는 경우
            host = schemeSplit[1].substring(0, pathIndex);
            path = schemeSplit[1].substring(pathIndex);
        } else if (pathIndex == -1 && queryIndex != -1) {
            // query만 있는 경우
            host = schemeSplit[1].substring(0, queryIndex);
            queryString = schemeSplit[1].substring(queryIndex+1);
        } else {
            // 둘 다 있는 경우
            host = schemeSplit[1].substring(0, pathIndex);
            path = schemeSplit[1].substring(pathIndex, queryIndex);
            queryString = schemeSplit[1].substring(queryIndex+1);
        }

        if (!queryString.equals("")) {
            String[] querys = queryString.split("&");
            for (String query : querys) {
                String[] keyValue = query.split("=");
                queryMap.put(keyValue[0], keyValue[1]);
            }
        }

        return new Uri(scheme, host, path, queryMap);
    }

    // 이 클래스는 수정하지 않아도 됩니다.
    static class Uri {
        private String scheme;
        private String host;
        private String path;
        private Map<String, String> query;

        public Uri(String scheme, String host, String path, Map<String, String> query) {
            this.scheme = scheme;
            this.host = host;
            this.path = path;
            this.query = query;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Map<String, String> getQuery() {
            return query;
        }

        public void setQuery(Map<String, String> query) {
            this.query = query;
        }

        @Override
        public String toString() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("{");
            if (query != null) {
                String pair = query.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining(", "));
                queryBuilder.append(pair);
            }
            queryBuilder.append("}");
            return String.format(
                    "Uri(scheme=%s, host=%s, path=%s, query=%s)",
                    scheme != null ? scheme : "",
                    host != null ? host : "",
                    path != null ? path : "",
                    queryBuilder.toString());
        }
    }
}
