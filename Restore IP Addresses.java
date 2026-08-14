class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           StringBuilder path, List<String> result) {

        if (parts == 4 && index == s.length()) {
            result.add(path.substring(0, path.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') break;

            int value = Integer.parseInt(part);
            if (value <= 255) {
                int before = path.length();
                path.append(part).append('.');
                backtrack(s, index + len, parts + 1, path, result);
                path.setLength(before);
            }
        }
    }
}
