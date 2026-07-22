import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();

        List<int[]> tmp = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            char c = s.charAt(i);
            while (j < n && s.charAt(j) == c) j++;
            tmp.add(new int[]{c - '0', i, j - 1});
            i = j;
        }
        int m = tmp.size();
        int[] type = new int[m], start = new int[m], end = new int[m], len = new int[m];
        for (int k = 0; k < m; k++) {
            int[] b = tmp.get(k);
            type[k] = b[0]; start[k] = b[1]; end[k] = b[2]; len[k] = end[k] - start[k] + 1;
        }

        int[] blockOf = new int[n];
        for (int k = 0; k < m; k++)
            for (int p = start[k]; p <= end[k]; p++) blockOf[p] = k;

        int totalOnes = 0;
        for (int p = 0; p < n; p++) if (s.charAt(p) == '1') totalOnes++;

        final int NEG = Integer.MIN_VALUE / 2;
        final int POS = Integer.MAX_VALUE / 2;

        int[] Z = new int[m], Lmin = new int[m], G = new int[m];
        for (int k = 0; k < m; k++) {
            Z[k] = (type[k] == 0) ? len[k] : NEG;
            Lmin[k] = (type[k] == 1) ? len[k] : POS;
            G[k] = (type[k] == 1 && k - 1 >= 0 && k + 1 < m) ? len[k - 1] + len[k + 1] : NEG;
        }

        SparseTable stZ = new SparseTable(Z, true);
        SparseTable stG = new SparseTable(G, true);
        SparseTable stL1 = new SparseTable(Lmin, false);

        int q = queries.length;
        List<Integer> answer = new ArrayList<>(q);

        for (int qi = 0; qi < q; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            int bl = blockOf[l], br = blockOf[r];

            // Whole query sits inside a single block -> no interior 1-block exists -> no trade possible
            if (bl == br) {
                answer.add(totalOnes);
                continue;
            }

            int Lbl = end[bl] - l + 1;
            int Lbr = r - start[br] + 1;

            boolean hasInterior = bl + 1 <= br - 1;
            if (!hasInterior) {
                answer.add(totalOnes);
                continue;
            }

            int minL1 = stL1.query(bl + 1, br - 1);
            if (minL1 >= POS) {
                answer.add(totalOnes); // no interior 1-block -> no trade possible
                continue;
            }

            int maxZ = NEG;
            if (type[bl] == 0) maxZ = Math.max(maxZ, Lbl);
            if (type[br] == 0) maxZ = Math.max(maxZ, Lbr);
            maxZ = Math.max(maxZ, stZ.query(bl + 1, br - 1));

            int mergeGain = NEG;
            if (type[bl + 1] == 1) {
                int left = Lbl;
                int right = (bl + 2 == br) ? Lbr : len[bl + 2];
                mergeGain = Math.max(mergeGain, left + right);
            }
            if (br - 1 != bl + 1 && type[br - 1] == 1) {
                int right = Lbr;
                int left = (br - 2 == bl) ? Lbl : len[br - 2];
                mergeGain = Math.max(mergeGain, left + right);
            }
            if (bl + 2 <= br - 2) {
                mergeGain = Math.max(mergeGain, stG.query(bl + 2, br - 2));
            }

            int separateGain = maxZ - minL1;

            int gain = Math.max(mergeGain, separateGain);
            if (gain < 0) gain = 0;

            answer.add(totalOnes + gain);
        }

        return answer;
    }

    static class SparseTable {
        int[][] table;
        int[] log;
        int n;
        boolean isMax;

        SparseTable(int[] arr, boolean isMax) {
            this.isMax = isMax;
            n = arr.length;
            log = new int[n + 1];
            for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;
            int K = (n == 0) ? 1 : log[n] + 1;
            table = new int[K][n];
            if (n > 0) table[0] = arr.clone();
            for (int k = 1; k < K; k++) {
                int half = 1 << (k - 1);
                for (int idx = 0; idx + (1 << k) <= n; idx++) {
                    table[k][idx] = isMax
                        ? Math.max(table[k - 1][idx], table[k - 1][idx + half])
                        : Math.min(table[k - 1][idx], table[k - 1][idx + half]);
                }
            }
        }

        int query(int l, int r) {
            if (l > r) return isMax ? Integer.MIN_VALUE / 2 : Integer.MAX_VALUE / 2;
            int k = log[r - l + 1];
            return isMax
                ? Math.max(table[k][l], table[k][r - (1 << k) + 1])
                : Math.min(table[k][l], table[k][r - (1 << k) + 1]);
        }
    }
}
