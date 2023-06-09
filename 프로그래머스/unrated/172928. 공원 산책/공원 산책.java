import java.util.*;

class Solution {
    private int y, x;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        Map<String, int[]> dir = new HashMap<>();
        dir.put("E", new int[]{0,1});
        dir.put("W", new int[]{0,-1});
        dir.put("S", new int[]{1,0});
        dir.put("N", new int[]{-1,0});
        
        int n = park.length, m = park[0].length();
        findStart(n, m, park);
        
        for(int i=0 ; i<routes.length ; i++){
            String[] values = routes[i].split(" ");
            int[] d = dir.get(values[0]);
            int ny = y + d[0] * Integer.parseInt(values[1]), nx = x + d[1] * Integer.parseInt(values[1]);
               
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || findX(y, x, d[0], d[1], Integer.parseInt(values[1]), park))continue;
            System.out.println(park[ny].charAt(nx));
            y = ny;
            x = nx;
        }
        answer = new int[]{y, x};
        return answer;
    }
    
    private void findStart(int n, int m, String[] park){
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(park[i].charAt(j) == 'S'){
                    y = i;
                    x = j;
                    return;
                }
            }
        }
    }
    
    private boolean findX(int y, int x, int dy, int dx, int size, String[] park){
        for(int i=0 ; i<size ; i++){
            y += dy;
            x += dx;
            if(park[y].charAt(x) == 'X')return true;
        }
        return false;
    }
}