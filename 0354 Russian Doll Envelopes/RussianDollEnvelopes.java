class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        
        int[] seq = new int[envelopes.length];
        int size = 0;
        for (int[] envelope: envelopes) {
            int start = 0;
            int end = size;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (seq[mid] < envelope[1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            seq[end] = envelope[1];
            if (end == size) {
                size++;
            }
        }
        return size;
    }
}