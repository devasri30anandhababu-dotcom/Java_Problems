import java.util.*;

class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] row : times) {
            graph.computeIfAbsent(row[0], x -> new ArrayList<>())
                 .add(new int[]{row[1], row[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        pq.offer(new int[]{k, 0});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int node = cur[0];
            int time = cur[1];

            if (dist.containsKey(node))
                continue;

            dist.put(node, time);

            if (graph.containsKey(node)) {
                for (int[] nei : graph.get(node)) {

                    int next = nei[0];
                    int wt = nei[1];

                    if (!dist.containsKey(next)) {
                        pq.offer(new int[]{next, time + wt});
                    }
                }
            }
        }

        if (dist.size() != n)
            return -1;

        return Collections.max(dist.values());
    }
}
