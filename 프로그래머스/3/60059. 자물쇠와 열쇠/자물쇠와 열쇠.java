import java.util.*;

class Solution {
    int n, cnt, m;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        n = lock.length;
        m = key.length;
    
        cnt = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++)
                if(lock[i][j] == 0)
                    cnt++;
        }
    
        int rotation = 4;
        while(rotation-- > 0){
            for(int i=-m ; i<n ; i++){
                for(int j=-m ; j<n ; j++){
                    if(checkUnlock(i, j, key, lock)){
                        return true;
                    }
                }
            }
            
            key = keyRotation(key);
        }
        
        return false;
    }
    
    private int[][] keyRotation(int[][] key){
        int[][] ret = new int[m][m];
        
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<m ; j++){
                ret[j][m - i - 1] = key[i][j];
            }
        }
        
        return ret;
    }
    
    private boolean checkUnlock(int startY, int startX, int[][] key, int[][] lock){
        int ret = 0;
        
        for(int i=0 ; i<m ; i++){
            int y = startY + i;
            if(0 > y || y >= n)
                continue;
            
            for(int j=0 ; j<m ; j++){
                int x = startX + j;
                
                if(0 > x || x >= n)
                    continue;
                
                if(lock[y][x] == 0 && key[i][j] == 1)
                    ret++;
                else if(lock[y][x] == 1 && key[i][j] == 1)
                    return false;
            }
        }
        
        return ret == cnt;
    }
}