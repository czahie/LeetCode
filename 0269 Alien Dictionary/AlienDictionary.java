class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // build a directed graph and populate the inDegree map
        for (String word: words) {
            for (char c: word.toCharArray()) {
                inDegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            int len = Math.min(currWord.length(), nextWord.length());
            for (int j = 0; j < len; j++) {
                char currChar = currWord.charAt(j);
                char nextChar = nextWord.charAt(j);
                if (currChar != nextChar) {
                    Set<Character> set;
                    if (!graph.containsKey(currChar)) {
                        set = new HashSet<>();
                    } else {
                        set = graph.get(currChar);
                    }
                    // make sure no duplicated indegee increment
                    // otherwise, some char may end up with indegree more than 0 but actually not
                    // because of counted more than once
                    if (!set.contains(nextChar)) {
                        set.add(nextChar);
                        graph.put(currChar, set);
                        inDegree.put(nextChar, inDegree.get(nextChar) + 1);
                    }
                    break;
                }
            }
        }
        
        // topo sort
        int count = 0;
        Queue<Character> q = new LinkedList<>();
        for (char k: inDegree.keySet()) {
            if (inDegree.get(k) == 0) {
                q.add(k);
            }
        }
        while (!q.isEmpty()) {
            char v = q.poll();
            count++;
            sb.append(v);
            if (graph.containsKey(v)) {
                for (char n: graph.get(v)) {
                    inDegree.put(n, inDegree.get(n) - 1);
                    if (inDegree.get(n) == 0) {
                        q.add(n);
                    }
                }
            }
        }
        
        if (count == inDegree.size()) {
            return sb.toString();
        }
        return "";
    }
}