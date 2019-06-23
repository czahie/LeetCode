class Solution {
    public double[] sampleStats(int[] count) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double mean = -1;
        double mode = -1;
        double median = -1;
        double totalCount = 0;
        double totalSum = 0;
        long medianPos = -1;
        int maxCount = 0;
        boolean odd = false;
        for (int i = 0; i < count.length; i++) {
            // update min
            if (count[i] > 0 && i < min) {
                min = i;
            }
            // update max
            if (count[i] > 0 && i > max) {
                max = i;
            }
            // update mode 
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
            }
            totalCount += count[i];
            totalSum += count[i] * i; 
        }
        // calculate mean
        mean = totalSum / totalCount;
        // find median
        medianPos = (long) totalCount / 2;
        if ((long) totalCount % 2 == 1) {
            odd = true;
        }
        totalCount = 0;
        double prevCount = 0;
        for (int i = 0; i < count.length; i++) {
            prevCount = totalCount;
            totalCount += count[i];
            if (totalCount > medianPos && odd) {
                median = i;
                break;
            } else if (totalCount > medianPos && !odd) {
                if (prevCount == medianPos) {
                    median = (double) (i + i - 1) / 2;
                } else {
                    median = i;
                }
                break;
            }  
        }
        double[] res = new double[]{min, max, mean, median, mode};
        return res;
    }
}