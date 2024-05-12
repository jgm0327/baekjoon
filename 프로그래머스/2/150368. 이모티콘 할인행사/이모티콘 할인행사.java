import java.util.*;

class Solution {
    int[] answer = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        dfs(0, users, emoticons, 0, new HashMap<>(), new int[users.length]);
        return answer;
    }
    
    private void dfs(int depth, int[][]users, int[] emo, int total, HashMap<Integer, Boolean> visit, int[] purchase){
        
        if(depth == emo.length){
            int signup = visit.size();
            if(answer[0] < signup)answer = new int[]{signup, total};
            
            else if(answer[0] == signup 
                    && total > answer[1])answer = new int[]{signup, total};
            
            return;
        }
        
        boolean[] discount = new boolean[users.length];
        for(int i=10 ; i<=40 ; i += 10){
            int discountEmo = (emo[depth] - ((emo[depth] * i) / 100));
     
            int sum = 0;
            
            for(int j=0 ; j<users.length ; j++){
                if(users[j][0] > i || visit.containsKey(j))continue;
                
                sum += discountEmo;
                discount[j] = true;
                purchase[j] += discountEmo;
         
                if(!visit.containsKey(j) && purchase[j] >= users[j][1])sum -= purchase[j];
                if(visit.containsKey(j) || purchase[j] < users[j][1])continue;
                visit.put(j, true);
            }
            
            
            dfs(depth + 1, users, emo, total + sum, visit, purchase);
            
            for(int j=0 ; j<users.length ; j++){
                if(!discount[j])continue;
                purchase[j] -= discountEmo;
                discount[j] = false;
                
                if(!visit.containsKey(j) || purchase[j] >= users[j][1])continue;
                visit.remove(j);
            }
        }
    }
}