class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        int province = 0;
        boolean[] visit = new boolean[size];

        for(int i = 0; i < size; i++){
            if(!visit[i]){
                dfs(isConnected, visit, i);
                province++;
            }
        }

        return province;
    }

    private void dfs(int[][] graph, boolean[] visit, int node){
        visit[node] = true;

        for(int i = 0; i < graph.length; i++){
            if(graph[node][i] == 1 && !visit[i]){
                dfs(graph, visit, i);
            }
        }
    }
}
