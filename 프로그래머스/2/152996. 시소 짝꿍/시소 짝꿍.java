import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Long, Long> count = new HashMap<>();
        
        for(int weight : weights){
            count.put((long)weight, count.getOrDefault((long)weight, 0L) + 1L);
        }
        
        List<Long> list = new ArrayList<>();
        for(long key : count.keySet()){
            long value = count.get(key);
            answer += (value * (value - 1)) / 2;
            list.add((long)key);
        }
        
        final long[][] mul = {{2L, 3L}, {3L, 2L}, {2L, 4L}, {4L, 2L}, {3L, 4L}, {4L, 3L}};
        
        System.out.println(list);
        for(int i=0 ; i<list.size() ; i++){
            long num1 = list.get(i);
            for(int j=i+1 ; j<list.size() ; j++){
                long num2 = list.get(j);
                
                for(long[] d : mul){
                    if(num1 * d[0] != num2 * d[1])
                        continue;
                    
                    answer += (count.get(num2) * count.get(num1));
                    break;
                }
            }
        }

        return answer;
    }
}