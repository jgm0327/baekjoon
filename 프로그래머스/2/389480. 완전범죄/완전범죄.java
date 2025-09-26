class Solution {
    int maxValue = -1;
    public int solution(int[][] info, int n, int m) {
        int totalB = 0;
        for(int[] amount : info){
            totalB += amount[1];
        }
        
        if(totalB < m)
            return 0;
        
        dfs(info, n, m, 0, new boolean[info.length][n + 1][m + 1]);
        return maxValue == -1 ? -1 : n - maxValue;
    }
    
    private void dfs(int[][] info, int A, int B, int idx, boolean[][][] visit){
        if(A <= 0 || B <= 0 || maxValue >= A || (idx < info.length && visit[idx][A][B]))
            return;
        
        if(idx == info.length){
            maxValue = Math.max(maxValue, A);
            return;
        }
        
        visit[idx][A][B] = true;
        
        dfs(info, A - info[idx][0], B, idx + 1, visit);
        dfs(info, A, B - info[idx][1], idx + 1, visit);
    }
        
}