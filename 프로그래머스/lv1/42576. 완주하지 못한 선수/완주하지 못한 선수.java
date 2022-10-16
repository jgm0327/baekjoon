import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> players = new HashMap<String, Integer>();
        for(String player : participant){
            if(players.containsKey(player)){
                int next_value = players.get(player) + 1;
                players.replace(player, next_value);
            }
            else{
                players.put(player, 1);
            }
        }
        for(String key : completion){
            int next_value = players.get(key) - 1;
            if(next_value == 0){
                players.remove(key);
            }
            else{
                players.replace(key, next_value);
            }
        }
        answer = (String)players.keySet().toArray()[0];
        return answer;
    }
}