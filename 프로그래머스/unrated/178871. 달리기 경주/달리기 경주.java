import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = callings.length, m = players.length;
        
        Map<String, Integer> index = new HashMap<>();
        for(int i=0 ; i<m ; i++){
            index.put(players[i], i);
        }
        
        for(int i=0 ; i<n ; i++){
            int j = index.get(callings[i]);
            String temp = players[j];
            players[j] = players[j - 1];
            players[j - 1] = temp;
            index.put(players[j - 1], j - 1);
            index.put(players[j], j);
        }
        return players;
    }
}