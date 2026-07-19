import java.util.Arrays;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!union(parent, rank, u, v)) return edge;
        }
        return new int[0];
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) 
            parent[x] = find(parent, parent[x]); // path compression
        return parent[x];
    }

    private static boolean union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) return false; // cycle detected
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
    
}
