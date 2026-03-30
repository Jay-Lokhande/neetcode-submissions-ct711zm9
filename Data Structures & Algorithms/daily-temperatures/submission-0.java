class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        int idx = 0;
        for (int i = 0; i < temperatures.length; i++) {
            int tem = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[0] < tem) {

                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            } 

            stack.push(new int[]{tem, i});
        }

        return res;
    }
}
