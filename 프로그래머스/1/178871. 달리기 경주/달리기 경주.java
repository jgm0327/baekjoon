import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> indices = new HashMap<>();
        for(int i=0 ; i<players.length ; i++){
            indices.put(players[i], i);
        }
        
        for(String calling : callings){
            int idx = indices.get(calling);
            int front = idx - 1;
            
            indices.put(calling, front);
            indices.put(players[front], idx);
            
            String temp = players[idx];
            players[idx] = players[front];
            players[front] = temp;
        }
        
        return players;
    }
}