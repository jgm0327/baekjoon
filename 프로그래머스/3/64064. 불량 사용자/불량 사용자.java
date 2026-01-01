import java.util.*;

class Solution {
    // 비트마스킹으로 banned_id에서 매칭할 수 있는 id들 보기
    int[] possible;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        possible = new int[banned_id.length];
        for(int i=0 ; i<banned_id.length ; i++){
            possible[i] = findIdCanMatching(user_id, banned_id[i]);
        }
        
        answer = dfs(0, new HashMap<>(), 0, user_id.length);
        
        return answer;
    }
    
    int dfs(int idx, Map<Integer, Boolean> exist, int visit, int n){
        if(idx == possible.length){
            if(!exist.containsKey(visit)){
                exist.put(visit, true);
                return 1;
            }                
            
            return 0;
        }
        
        int ret = 0;
        for(int i=0 ; i<n ; i++){
            if((possible[idx] & (1 << i)) == 0 || (visit & (1 << i)) != 0)
                continue;
            
            ret += dfs(idx + 1, exist, visit | (1 << i), n);
        }
        return ret;
    }
    
    int findIdCanMatching(String[] user_id, String banned_id){
        int bit = 0;
        
        for(int i=0 ; i<user_id.length ; i++){
            String id = user_id[i];
            
            if(banned_id.length() != id.length())
                continue;
            
            boolean flag = true;
            for(int j=0 ; j<id.length() ; j++){
                if(banned_id.charAt(j) != '*' && banned_id.charAt(j) != id.charAt(j)){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                bit |= (1 << i);
        }
        
        return bit;
    }
}