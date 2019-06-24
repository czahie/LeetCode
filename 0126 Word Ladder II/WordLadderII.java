class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() < 1) {
            return res;
        }
        // adjacency list for a directed graph
        Map<String, List<String>> map = new HashMap<>();
        // shortest length
        int min = Integer.MAX_VALUE;
        // word <--> distance
        Map<String, Integer> ladder = new HashMap<>();
        
        for (String word: wordList) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        wordList.add(endWord);
        ladder.put(beginWord, 0);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        // Dijkstra Search
        while (!q.isEmpty()) {
            String word = q.poll();
            int step = ladder.get(word) + 1;
            if (step > min) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if (ladder.containsKey(newWord)) {
                        if (ladder.get(newWord) < step) {
                            continue;
                        } else if (ladder.get(newWord) > step) {
                            ladder.put(newWord, step);
                            q.add(newWord);
                        } // if step == ladder.get(newWord), just move on
                        
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        backtrack(beginWord, endWord, res, new LinkedList<String>(), map);
        return res;
    }
    
    private void backtrack(String beginWord, String word, List<List<String>> res, List<String> curr, 
                           Map<String, List<String>> map) {
        if (word.equals(beginWord)) {
            curr.add(0, beginWord);
            res.add(new LinkedList<>(curr));
            curr.remove(0);
            return;
        }
        curr.add(0, word);
        if (map.get(word) != null) {
            for (String currWord: map.get(word)) {
                backtrack(beginWord, currWord, res, curr, map);
            }
        }
        curr.remove(0);   
    }
}