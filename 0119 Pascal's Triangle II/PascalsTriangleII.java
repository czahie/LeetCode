class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
