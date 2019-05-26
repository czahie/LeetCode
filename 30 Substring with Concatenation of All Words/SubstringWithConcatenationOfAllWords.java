    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (words == null || words.length < 1) {
                return res;
            }
            Map<String, Integer> wordsMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                wordsMap.put(words[i], wordsMap.getOrDefault(words[i], 0) + 1);
            }
            int wordLen = words[0].length();
            int n = words.length;
            for (int i = 0; i <= s.length() - n * wordLen; i++) {
                Map<String, Integer> count = new HashMap<>();
                int j = 0;
                while (j < n) {
                    String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                    if (!wordsMap.containsKey(word)) {
                        break;
                    }
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    if (count.get(word) > wordsMap.get(word)) {
                        break;
                    }
                    j++;
                }
                if (j == n) {
                    res.add(i);
                }
            }
            return res;
        }
    }