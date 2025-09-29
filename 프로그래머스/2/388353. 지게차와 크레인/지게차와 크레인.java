import java.util.*;

class Solution {
    Map<Character, List<int[]>> points;
    boolean[][] already;
    int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    int n, m;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        points = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                char ch = storage[i].charAt(j);
                
                if(!points.containsKey(ch))
                    points.put(ch, new ArrayList<>());
                
                points.get(ch).add(new int[]{i, j});
            }
        }
        
        already = new boolean[n][m];
        int total = n * m;
        for(String request : requests){
            if(!points.containsKey(request.charAt(0)))
                continue;
            if(request.length() == 1){
                total -= calculateCnt(request.charAt(0), storage, false);
            }
            else{
                total -= calculateCnt(request.charAt(0), storage, true);
            }
        }
        
        return total;
    }
    
    private int calculateCnt(char ch, String[] storage, boolean isCrane){
        int ret = 0;
        
        List<int[]> list = new ArrayList<>();
        for(int[] pos : points.get(ch)){
            if(already[pos[0]][pos[1]])
                continue;
            
            if(isCrane){
                already[pos[0]][pos[1]] = true;
                ret++;
            }
            else if(canTake(pos[0], pos[1], storage)){
                list.add(new int[]{pos[0], pos[1]});
                ret++;
            }
        }
        
        for(int[] pos : list){
            already[pos[0]][pos[1]] = true;
        }
        return ret;
    }
    
    private boolean canTake(int y, int x, String[] storage){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{y, x});
        
        boolean[][] visit = new boolean[n][m];
        visit[y][x] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            for(int i=0 ; i<4 ; i++){
                int ny = cur[0] + dy[i], nx = cur[1] + dx[i];
                
                if(0 > ny || ny >= n || 0 > nx || nx >= m)
                    return true;
                
                if(!already[ny][nx] || visit[ny][nx])
                    continue;
                
                visit[ny][nx] = true;
                que.add(new int[]{ny, nx});
            }
        }
        
        return false;
    }
}