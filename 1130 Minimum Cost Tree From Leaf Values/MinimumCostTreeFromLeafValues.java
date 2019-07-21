class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int n: arr) {
            while (stack.peek() <= n) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), n);
            }
            stack.push(n);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}