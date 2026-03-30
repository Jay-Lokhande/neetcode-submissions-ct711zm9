class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int n = n1;
        boolean flag = false;
        if (n1 > n2) {
            flag = true;
            n = n2;
        }
        String res = "";
        int i = 0;
        if (flag) {
            for (; i < n; i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            res += word1.substring(i);
        } else {
            for (; i < n; i++) {
                res += word1.charAt(i);
                res += word2.charAt(i);
            }
            res += word2.substring(i);
        }

        return res;
    }
}