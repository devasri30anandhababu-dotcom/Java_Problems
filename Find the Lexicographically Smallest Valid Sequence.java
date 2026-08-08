import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = m - 1 - j;
        }

        List<Integer> ans = new ArrayList<>();
        boolean used = false;

        int i = 0;
        j = 0;

        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans.add(i);
                i++;
                j++;
            } else {
      
                if (!used && suf[i + 1] >= m - j - 1) {
                    ans.add(i);
                    used = true;
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
        }

        if (j != m) return new int[0];

        int[] res = new int[m];
        for (int k = 0; k < m; k++) {
            res[k] = ans.get(k);
        }

        return res;
    }
}
