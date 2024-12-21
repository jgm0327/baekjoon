import java.util.*;

class Solution {
    private Map<String, Integer> indices;
    private int[] path;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        indices = new HashMap<>();
        indices.put("-", 0);
        for(int i=0 ; i<n ; i++){
            indices.put(enroll[i], i + 1);
        }
        
        path = new int[n + 1];
        
        for(int child=0 ; child<n ; child++){
            int parent = indices.get(referral[child]);
            
            path[child + 1] = parent;
        }
        
        for(int i=0 ; i<seller.length ; i++){
            dfs(indices.get(seller[i]), amount[i] * 100, answer);
        }
        
        return answer;
    }
    
    private void dfs(int child, int totalAmount, int[] answer){
        int fee = (int)(totalAmount * 0.1);
        int profit = totalAmount - fee;
        
        answer[child - 1] += profit;
        int parent = path[child];
        
        if(parent == 0)
            return;
        
        dfs(parent, fee, answer);
    }
}