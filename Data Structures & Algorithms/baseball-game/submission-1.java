class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op: operations) {

            if (op.equals("+")) {
                int top = stack.pop();
                int nextTop = stack.pop();
                int sum = top + nextTop;

                stack.push(nextTop);
                stack.push(top);
                stack.push(sum);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int top = stack.pop();
                int mul = top * 2;

                stack.push(top);
                stack.push(mul);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;

    }
}