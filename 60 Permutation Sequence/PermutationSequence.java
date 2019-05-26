class Solution {
    public String getPermutation(int n, int k) {
        int[] facts = new int[n + 1];
        List<Integer> nums = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // populate the facts array
        facts[0] = 1;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            facts[i] = sum;
        }
        // populate the nums array
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        for (int i = n; i >= 1; i--) {
            int index = k / facts[i - 1];
            sb.append(nums.get(index));
            nums.remove(index);
            k %= facts[i - 1];
        }
        return sb.toString();
    }
}