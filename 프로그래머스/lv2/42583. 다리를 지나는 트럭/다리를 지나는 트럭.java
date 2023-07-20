import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, total = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int truck_weight : truck_weights){
            while(true){
                if(que.isEmpty()){
                    total += truck_weight;
                    que.add(truck_weight);
                    answer++;
                    break;
                }else if(que.size() == bridge_length){
                    total -= que.poll();
                }else{
                    if(truck_weight + total <= weight){
                        que.add(truck_weight);
                        total += truck_weight;
                        answer++;
                        break;
                    }else{
                        answer++;
                        que.add(0);
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}