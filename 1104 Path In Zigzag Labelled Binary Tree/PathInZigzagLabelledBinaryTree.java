class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        int log = 1;
        // find the minimum of the label's next row
        while (log <= label) {
            log *= 2;
        }
        while (label >= 1) {
            res.add(label);
            label /= 2;
            log /= 2;
            // max = log - 1, min = log / 2, reverse the above level
            label = log / 2 + log - 1 - label;
        }
        Collections.reverse(res);
        return res;
    }
}