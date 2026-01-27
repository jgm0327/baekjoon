class Solution {
    public int solution(int n) {
        int answer = 0;
        return dfs(n, n) / (n + 1);
    }
    
    int dfs(int open, int close){
        if(close == 0 || open == 0){
            return 1;
        }
        
        return dfs(open - 1, close) + dfs(open, close - 1);
    }
}