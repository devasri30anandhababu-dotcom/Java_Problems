import java.util.*;

class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String airport) {

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        ans.add(airport);
    }
}
