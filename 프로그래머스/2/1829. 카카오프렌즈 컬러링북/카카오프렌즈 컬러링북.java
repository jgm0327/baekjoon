import java.util.*;

class Solution {
    private boolean[][] visit;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        visit = new boolean[m][n];
        
        for(int y = 0 ; y < m ; y++){
            for(int x = 0 ; x < n ; x++){
                if(visit[y][x] || picture[y][x] == 0)continue;
                answer[0]++;
                answer[1] = Math.max(answer[1], bfs(y, x, picture, m, n));
            }
        }
        
        return answer;
    }
    
    private int bfs(int startY, int startX, final int[][] picture, int n, int m){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startY, startX});
        visit[startY][startX] = true;
        
        int number = picture[startY][startX];
        
        final int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
        
        int ret = 0;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0], x = cur[1];
            
            ret++;
            
            for(int i=0 ; i<4 ; i++){
                int nextY = y + dy[i], nextX = x + dx[i];
                if(0 > nextY || nextY >= n || 0 > nextX || nextX >= m 
                   || visit[nextY][nextX] || picture[nextY][nextX] != number)
                    continue;
                
                visit[nextY][nextX] = true;
                que.add(new int[]{nextY, nextX});
            }    
        }
        
        return ret;
    }
}