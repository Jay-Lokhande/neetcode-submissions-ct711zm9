class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((ch >= '0' && ch <= '9') || 
                (ch >= 'A' && ch <= 'Z') || 
                (ch >= 'a' && ch <= 'z')) {
                    sb.append(Character.toLowerCase(ch));
                }               
        }  


        return (sb.toString().equals(sb.reverse().toString()));
    }
}
