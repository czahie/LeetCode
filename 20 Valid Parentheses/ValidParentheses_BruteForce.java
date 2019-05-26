class ValidParentheses_BruteForce {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c); 
                }
                else {
                    return false;
                }
            }
            else if (!stack.isEmpty()){
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}