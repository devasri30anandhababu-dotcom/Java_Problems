class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0)
            return ans;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;

            while (j < totalWords) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);

                if (!map.containsKey(word))
                    break;

                seen.put(word, seen.getOrDefault(word, 0) + 1);

                if (seen.get(word) > map.get(word))
                    break;

                j++;
            }

            if (j == totalWords)
                ans.add(i);
        }

        return ans;
    }
}
