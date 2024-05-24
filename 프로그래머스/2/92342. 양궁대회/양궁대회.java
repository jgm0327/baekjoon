/*
k 점을 더 많이 맞춘 사람이 k점 가져감 (단, 맞춘 횟수가 같으면 어피치가 k점 a=b=0이면 아무도 못 가져감)

*/

class Solution {
    private int[] answer, temp;
    private boolean isOver = false;
    private int maxValue = 0;
    
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        temp = new int[info.length];
        int apeach = 0;
        
        for(int i=0 ; i<info.length ; i++){
            if(info[i] == 0)continue;
            apeach += (10 - i);
        }
        
        dfs(10, n, 0, 0, apeach, info);
        
        return isOver ? answer : new int[]{-1};
    }
    
    private void dfs(int score, int n, int total, int lion, int apeach, final int[] info){
        
        if(total == n && lion > apeach){
            if(maxValue < (lion - apeach) ||
               (maxValue == (lion - apeach) && check(answer, temp))){
                
                for(int i=0 ; i<11 ; i++)answer[i] = temp[i];
                maxValue = (lion - apeach);
            }
            
            isOver = true;
            return;
        }
        
        if(score < 0)return;
        
        for(int i=0 ; i<=n ; i++){
            if(total + i > n)return;
            
            temp[10 - score] = i;
            int t1 = 0, t2 = 0;
            
            if(info[10 - score] < temp[10 - score]){
                t1 = score;
                t2 = score;
            }
            
            if(info[10 - score] == 0)
                t2 = 0;
            
            dfs(score - 1, n, total + i, lion + t1, apeach - t2, info);
            
            temp[10 - score] = 0;
        }
    }
    
    private boolean check(int[] answer, int[] temp){
        for(int i=10 ; i>=0 ; i--){
            if(answer[i] < temp[i])return true;
            else if(answer[i] > temp[i])return false;
        }
        
        return false;
    }
}