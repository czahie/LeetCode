class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d: dominoes) {
            int key = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (Integer k: map.keySet()) {
            int val = map.get(k);
            count += val * (val - 1) / 2;
        }
        return count;
    }
}