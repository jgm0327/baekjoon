import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> cloth_list = new HashMap<>();
        
        for(String[] cloth : clothes){
            String name = cloth[0], type = cloth[1];
            if(cloth_list.containsKey(type)){
                int next_value = cloth_list.get(type) + 1;
                cloth_list.replace(type, next_value);
                continue;
            }
            cloth_list.put(type, 1);
        }
        for(String key : cloth_list.keySet()){
            answer *= (cloth_list.get(key) + 1);
        }
        return answer - 1;
    }
}