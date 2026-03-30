class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];

            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }

            String sc = Arrays.toString(count);
            map.putIfAbsent(sc, new ArrayList<>());
            map.get(sc).add(s);
        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> m : map.values()) {
            res.add(m);
        }
        return res;
    }
}
