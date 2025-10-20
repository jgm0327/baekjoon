import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer, Integer>[][] times = new HashMap[101][101];
        for(int i=0 ; i<101 ; i++){
            for(int j=0 ; j<101 ; j++){
                times[i][j] = new HashMap<>();
            }
        }
        
        for(int[] route : routes){
            int time = 0;
            int y = points[route[0] - 1][0], x = points[route[0] - 1][1];
            
            times[y][x].put(time, times[y][x].getOrDefault(time++, 0) + 1);
            for(int i=1 ; i<route.length ; i++){
                int startY = points[route[i - 1] - 1][0], startX = points[route[i - 1] - 1][1];
                int endY = points[route[i] - 1][0], endX = points[route[i] - 1][1];
                
                while(startY > endY){
                    startY--;
                    times[startY][startX].put(time, times[startY][startX].getOrDefault(time++, 0) + 1);
                }
                
                while(startY < endY){
                    startY++;
                    times[startY][startX].put(time, times[startY][startX].getOrDefault(time++, 0) + 1);
                }
                
                while(startX > endX){
                    startX--;
                    times[startY][startX].put(time, times[startY][startX].getOrDefault(time++, 0) + 1);
                }
                
                while(startX < endX){
                    startX++;
                    times[startY][startX].put(time, times[startY][startX].getOrDefault(time++, 0) + 1);
                }
            }
        }
        
        for(int i=0 ; i<101 ; i++){
            for(int j=0 ; j<101 ; j++){
                for(int count : times[i][j].values()){
                    if(count >= 2)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}