import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> exist = new HashMap<>();
        
        for(int weight : tangerine){
            exist.put(weight, exist.getOrDefault(weight, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int key : exist.keySet()){
            list.add(exist.get(key));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int total = 0;
        for(int i=0 ; i<list.size() ; i++){
            total += list.get(i);
            if(total  >= k){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}