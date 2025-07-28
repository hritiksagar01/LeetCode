class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0 , rooms , visited);
        for(boolean visit : visited){
            if(!visit)
            return false;
        }            return true;

    }
    void dfs(int u,List<List<Integer>> rooms , boolean[] visited ){
        visited[u]=true;
        for(int v: rooms.get(u))
        if(!visited[v])
        dfs(v,rooms,visited);
    }
}