class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] count = new int[1001];
        for (int i: arr1) {
            count[i]++;
        }
        int[] res = new int[len1];
        int p = 0;
        for (int i = 0; i < len2; i++) {
            while (count[arr2[i]] > 0) {
                res[p] = arr2[i];
                p++;
                count[arr2[i]]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                res[p] = i;
                p++;
                count[i]--;
            }
        }
        return res;
    }
}