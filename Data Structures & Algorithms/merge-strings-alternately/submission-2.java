class Solution {
    public String mergeAlternately(String word1, String word2) {
        // int n1 = word1.length();
        // int n2 = word2.length();
        // int n = n1;
        // boolean flag = false;
        // if (n1 > n2) {
        //     flag = true;
        //     n = n2;
        // }
        // String res = "";
        // int i = 0;
        // if (flag) {
        //     for (; i < n; i++) {
        //         res += word1.charAt(i);
        //         res += word2.charAt(i);
        //     }
        //     res += word1.substring(i);
        // } else {
        //     for (; i < n; i++) {
        //         res += word1.charAt(i);
        //         res += word2.charAt(i);
        //     }
        //     res += word2.substring(i);
        // }

        // return res;

        int n = word1.length(), m = word2.length();

        StringBuilder res = new StringBuilder();

        // int i = 0, j = 0;

        // while (i < n || j < m) {
        //     if (i < n) res.append(word1.charAt(i++));
        //     if (j < m) res.append(word2.charAt(j++));
        // }

        // return res.toString();



        for (int i = 0; i < n || i < m; i++) {
            if (i < n) {
                res.append(word1.charAt(i));
            }
            if (i < m) {
                res.append(word2.charAt(i));
            }
        }

        return res.toString();
        
    }
}