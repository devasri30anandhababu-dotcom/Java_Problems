class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    private boolean[] isVisited;

    public void buildAdjancency(int[][] edges) {
        for (int i = 0; i < isVisited.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] each : edges) {
            adj.get(each[0]).add(each[1]);
            adj.get(each[1]).add(each[0]);
        }
    }

    public boolean bfs(int src, int dest) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);
        isVisited[src] = true;

        while (!que.isEmpty()) {
            int node = que.poll();

            if (node == dest) {
                return true;
            }

            for (int nei : adj.get(node)) {
                if (!isVisited[nei]) {
                    isVisited[nei] = true;
                    que.offer(nei);
                }
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int src, int dest) {
        isVisited = new boolean[n];
        adj = new ArrayList<>(); // Clear adjacency list
        buildAdjancency(edges);
        return bfs(src, dest);
    }
}
