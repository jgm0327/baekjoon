class Solution {
    private String answer;
    private char[] ch = {'d', 'l', 'r', 'u'};
    private final int[] dx = {1, 0, 0, -1}, dy = {0, -1 , 1, 0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "impossible";
        dfs(n, m, x, y, r, c, new StringBuilder(), k);
        return answer;
    }
    
    private void dfs(int n, int m, int x, int y, int r, int c, 
                     StringBuilder path, int dist){
        if((Math.abs(x - r) + Math.abs(y - c)) % 2 == 1 && dist % 2 == 0)
            return;
        if(Math.abs(x - r) + Math.abs(y - c) > dist)
            return;
        
        if(dist == 0){
            if(x == r && y == c)
                answer = path.toString();
            
            return;
        }
        
        for(int i=0 ; i<4 ; i++){
            int nx = x + dx[i], ny = y + dy[i];
            
            if(0 >= nx || nx > n || 0 >= ny || ny > m)
                continue;
            
            path.append(ch[i]);
            dfs(n, m, nx, ny, r, c, path, dist - 1);
            
            if(!answer.equals("impossible"))
                return;
            
            path.deleteCharAt(path.length() - 1);
        }
    }
}