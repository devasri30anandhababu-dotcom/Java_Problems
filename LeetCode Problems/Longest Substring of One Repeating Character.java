class Solution {
    class Node {
        int l, r;
        int prefix, suffix, best;
        char leftChar, rightChar;
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int idx, int l, int r) {
        tree[idx] = new Node();
        if (l == r) {
            tree[idx].leftChar = arr[l];
            tree[idx].rightChar = arr[l];
            tree[idx].prefix = tree[idx].suffix = tree[idx].best = 1;
            return;
        }

        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        pull(idx, l, r, mid);
    }

    private void update(int idx, int l, int r, int pos, char ch) {
        if (l == r) {
            arr[pos] = ch;
            tree[idx].leftChar = ch;
            tree[idx].rightChar = ch;
            tree[idx].prefix = tree[idx].suffix = tree[idx].best = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(idx * 2, l, mid, pos, ch);
        else
            update(idx * 2 + 1, mid + 1, r, pos, ch);

        pull(idx, l, r, mid);
    }

    private void pull(int idx, int l, int r, int mid) {
        Node left = tree[idx * 2];
        Node right = tree[idx * 2 + 1];
        Node cur = tree[idx];

        cur.leftChar = left.leftChar;
        cur.rightChar = right.rightChar;

        cur.prefix = left.prefix;
        if (left.prefix == mid - l + 1 && left.rightChar == right.leftChar) {
            cur.prefix += right.prefix;
        }

        cur.suffix = right.suffix;
        if (right.suffix == r - mid && left.rightChar == right.leftChar) {
            cur.suffix += left.suffix;
        }

        cur.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            cur.best = Math.max(cur.best, left.suffix + right.prefix);
        }
    }
}
