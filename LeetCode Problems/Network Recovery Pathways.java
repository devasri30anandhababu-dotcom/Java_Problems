import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int m = edges.length;
        List<int[]>[] adj = new List[n];
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] costs = new int[m];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], c = edges[i][2];
            adj[u].add(new int[]{v, c});
            indeg[v]++;
            costs[i] = c;
        }

        int[] topo = new int[n];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] indegCopy = indeg.clone();
        for (int i = 0; i < n; i++) if (indegCopy[i] == 0) q.add(i);
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : adj[u]) {
                if (--indegCopy[e[0]] == 0) q.add(e[0]);
            }
        }

        Integer[] sortedCosts = new Integer[m];
        for (int i = 0; i < m; i++) sortedCosts[i] = costs[i];
        Arrays.sort(sortedCosts);

        int lo = 0, hi = m - 1, ans = -1;
        long[] dist = new long[n];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int x = sortedCosts[mid];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            for (int i = 0; i < n; i++) {
                int u = topo[i];
                if (dist[u] == Long.MAX_VALUE) continue;
                if (u != 0 && !online[u]) continue;
                for (int[] e : adj[u]) {
                    int v = e[0], c = e[1];
                    if (c < x) continue;
                    if (dist[u] + c < dist[v]) dist[v] = dist[u] + c;
                }
            }
            boolean ok = dist[n - 1] != Long.MAX_VALUE && dist[n - 1] <= k;
            if (ok) {
                ans = x;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
