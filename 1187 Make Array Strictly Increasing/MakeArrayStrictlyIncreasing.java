class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        // remove duplicates
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (i == 0 || (i > 0 && arr2[i] != arr2[i - 1])) {
                list2.add(arr2[i]);
            }
        }
        int[] newArr2 = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            newArr2[i] = list2.get(i);
        }
        arr2 = newArr2;
        
        // add 2 elements to arr1
        int n = arr1.length;
        int[] newArr1 = new int[n + 2];
        for (int i = 0; i < n; i++) {
             newArr1[i + 1] = arr1[i];
        }
        newArr1[0] = Integer.MIN_VALUE;
        newArr1[n + 1] = Integer.MAX_VALUE;
        arr1 = newArr1;
        
        int[] dp = new int[n + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 2; i++) {
            for (int j = 0; j < i; j++) {
                if (arr1[j] < arr1[i] && dp[j] != Integer.MAX_VALUE) {
                    int amount = check(arr1, arr2, j, i);
                    if (amount >= 0) {
                        dp[i] = Math.min(dp[i], dp[j] + amount);
                    }

                }
            }
        }
        return dp[n + 1] == Integer.MAX_VALUE ? -1 : dp[n + 1];
    }
    
    private int check(int[] arr1, int[] arr2, int start, int end) {
        if (start + 1 == end) {
            return 0;
        }
        int min = arr1[start];
        int max = arr1[end];
        int idx = Arrays.binarySearch(arr2, min);
        if (idx < 0) {
            idx = -idx - 1;
        } else {
            idx += 1;
        }
        int maxCount = end - start - 1;
        int endi = idx + maxCount - 1;
        if (endi < arr2.length && arr2[endi] < max) {
            return maxCount;
        } else {
            return -1;
        }
    }
}