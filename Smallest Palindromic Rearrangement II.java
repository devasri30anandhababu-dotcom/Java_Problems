import java.util.*;

class Solution {
    private static final long LIMIT = 1_000_000L;
    private long[] fact = new long[5005];

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String mid = "";
        int[] half = new int[26];
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = String.valueOf((char)('a' + i));
            }
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        buildFactorials(halfLen);

        if (countPermutations(half) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int i = 0; i < 26; i++) {
                if (half[i] == 0) continue;

                half[i]--;
                long cnt = countPermutations(half);

                if (cnt >= k) {
                    left.append((char)('a' + i));
                    break;
                } else {
                    k -= cnt;
                    half[i]++;
                }
            }
        }

        String right = left.reverse().toString();
        left.reverse();

        return left.toString() + mid + right;
    }

    private void buildFactorials(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = Math.min(LIMIT, fact[i - 1] * i);
        }
    }

    private long countPermutations(int[] count) {
        int total = 0;
        for (int x : count) total += x;

        long res = fact[total];

        for (int x : count) {
            res /= fact[x];
        }

        return Math.min(res, LIMIT);
    }
}
