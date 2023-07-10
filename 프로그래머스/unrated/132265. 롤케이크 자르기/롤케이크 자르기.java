//map.size() 로 판단
//1차 반복문으로 가능한 방법을 찾아야한다.

/*
    이분탐색 -> 정렬 불가해서 탈락
    투포인터 -> 이것도 2차 반복문을 사용해야할 듯 (X)
    
*/
//맵을 이용해서 해야하나
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0 ; i<topping.length ; i++){
            count.put(topping[i], count.getOrDefault(topping[i], 0)+1);
        }
        
        Map<Integer, Boolean> brother = new HashMap<>();
        for(int i=0 ; i<topping.length ; i++){
            brother.put(topping[i], true);
            count.put(topping[i], count.get(topping[i]) - 1);
            if(count.get(topping[i]) == 0)count.remove(topping[i]);
            if(count.size() == brother.size())answer++;
        }
        return answer;
    }
}