import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == 2)cnt++;
        }
        
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] == 2 || answer.size() > 0){
                answer.add(arr[i]);
            }
            if(arr[i] == 2)cnt--;
            if(cnt == 0)break;
        }
        if(answer.size() == 0)answer.add(-1);
        return answer.stream().mapToInt(v -> v).toArray();
    }
}