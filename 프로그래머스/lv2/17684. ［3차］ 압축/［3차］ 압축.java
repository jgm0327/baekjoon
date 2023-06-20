import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        
        for(int i=0 ; i<26 ; i++){
            char ch = (char)('A' + i);
            dic.put(""+ch, i + 1);
        }
        
        int idx = 0, n = msg.length(), number = 26;
        while(idx < n){
            StringBuilder prev = new StringBuilder(""+msg.charAt(idx));
            StringBuilder next = new StringBuilder(""+msg.charAt(idx++));
            while(idx < n){
                String cur = "" + msg.charAt(idx);
                next.append(cur);
                if(!dic.containsKey(next.toString()))break;
                prev.append(cur);
                idx++;
            }
            
            if(!dic.containsKey(next.toString())){
                answer.add(dic.get(prev.toString()));
                dic.put(next.toString(), ++number);
            }else{
                answer.add(dic.get(next.toString()));
            }
        }
        
        return answer.stream().mapToInt(v -> v).toArray();
    }
}