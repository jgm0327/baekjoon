import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(String key : keymap){
            String[] str = key.split("");
            for(int i=0 ; i<str.length ; i++){
                if(!map.containsKey(str[i])) map.put(str[i], i+1);
                else if(map.get(str[i]) > i + 1) map.put(str[i], i+1);
            }
        }
        
        for(int i=0 ; i<targets.length ; i++){
            String[] str = targets[i].split("");
            int total = 0;
            for(String ch : str){
                if(!map.containsKey(ch)){
                    total = -1;
                    break;
                }
                total += map.get(ch);
            }
            answer[i] = total;
        }
        return answer;
    }
}