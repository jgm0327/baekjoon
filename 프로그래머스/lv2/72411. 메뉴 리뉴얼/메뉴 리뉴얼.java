import java.util.*;

class Solution {
    private boolean[] visit;
    private Map<String, Integer> count = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        Map<Integer, Boolean> courses = new HashMap<>();
        Map<Integer, Integer> maxValue = new HashMap<>();
        
        for(int i=0 ; i<orders.length ; i++){
            char[] str = orders[i].toCharArray();
            Arrays.sort(str);
            orders[i] = new String(str);
        }
        
        for(int i=0 ; i<orders.length ; i++){
            visit = new boolean[orders[i].length()];
            backtracking(orders[i], orders[i].length(), 0, new StringBuilder());
        }
        
        for(int i=0 ; i<course.length ; i++){
            courses.put(course[i], true);
        }
        
        for(String key : count.keySet()){
            int cnt = count.get(key);
            if(courses.containsKey(key.length())){
                int max = Math.max(cnt, maxValue.getOrDefault(key.length(), 0));
                maxValue.put(key.length(), max);
            }
        }
                                  
        List<String> list = new ArrayList<>();
        for(String key : count.keySet()){
            int cnt = count.get(key);
            if(maxValue.containsKey(key.length()) && maxValue.get(key.length()) == cnt && cnt >= 2){
                list.add(key);
            }
        }
        
        Collections.sort(list);
        return list.stream().toArray(String[]::new);
    }
    
    private void backtracking(String order, int n, int idx, StringBuilder sb){
        if(n <= idx || visit[idx])return;
        for(int i=idx ; i<n ; i++){
            if(visit[i])continue;
            sb.append(order.charAt(i));
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
            visit[i] = true;
            backtracking(order, n, i + 1, sb);
            visit[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}