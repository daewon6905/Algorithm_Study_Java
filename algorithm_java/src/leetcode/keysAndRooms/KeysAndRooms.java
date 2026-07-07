package leetcode.keysAndRooms;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[]visited = new boolean[n];
        dfs(0,rooms,visited);
        for(boolean bool : visited){
            if(!bool) return false;
        }
        return true;
    }

    void dfs(int room, List<List<Integer>>rooms, boolean[]visited){
        visited[room] = true;
        for(int nxt : rooms.get(room)){
            if(!visited[nxt]){
                visited[nxt] = true;
                dfs(nxt,rooms,visited);
            }
        }
    }
}
