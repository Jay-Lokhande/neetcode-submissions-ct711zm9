class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int top = stack.pop();
                int nextTop = stack.pop();

                if (s.equals("+")) {
                    stack.push(nextTop + top);
                } else if (s.equals("-")) {
                    stack.push(nextTop - top);
                } else if (s.equals("*")) {
                    stack.push(nextTop * top);
                } else if (s.equals("/")) {
                    stack.push(nextTop / top);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}
