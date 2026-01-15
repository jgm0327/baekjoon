import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> count = new HashMap<>();
        String[] tuples = s.split("}");
        for(String tuple : tuples){
            if(tuple.length() == 1)
                continue;
            
            tuple = tuple.replace("{", " ");
            String[] split = tuple.split(",");
            for(String data : split){
                if(data.strip().equals(""))
                    continue;
                
                int number = Integer.parseInt(data.strip());
                count.put(number, count.getOrDefault(number, 0) + 1);
            }
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        int[] answer = new int[count.size()];
        for(int key : count.keySet()){
            list.add(new int[]{key, count.get(key)});
        }
        
        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
        for(int i=0 ; i<list.size() ; i++)
            answer[i] = list.get(i)[0];
        
        return answer;
    }
}