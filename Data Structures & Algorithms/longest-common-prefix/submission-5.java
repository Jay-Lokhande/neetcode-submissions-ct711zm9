class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        if (n == 1) return strs[0];
        int m = strs[0].length();
        


        for (int i = 0; i < m; i++) {
            int ch = strs[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];

    }
}