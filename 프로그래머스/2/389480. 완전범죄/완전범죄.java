class Solution {
    int answer;
    boolean[][][] visit;
    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        visit = new boolean[info.length + 1][n + 1][m + 1];
        dfs(info, 0, 0, 0, n, m);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void dfs(int[][] info, int idx, int A, int B, int n, int m){
        if(A >= n || B >= m || visit[idx][A][B])
            return;
        
        visit[idx][A][B] = true;
        
        if(idx == info.length){
            answer = Math.min(answer, A);
            return;
        }
        
        dfs(info, idx + 1, A + info[idx][0], B, n, m);
        dfs(info, idx + 1, A, B + info[idx][1], n, m);
    }
}