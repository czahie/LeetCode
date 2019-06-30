class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int curr = 0;
        while (candies > 0) {
            res[curr % num_people] += Math.min(candies, curr + 1);
            curr++;
            candies -= curr;
        }
        return res;
    }
}