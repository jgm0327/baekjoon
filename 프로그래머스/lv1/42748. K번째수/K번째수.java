import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0 ; i<len ; i++){
            int start = commands[i][0] - 1, end = commands[i][1],
            location = commands[i][2] - 1;
            
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            answer[i] = arr[location];
        }
        return answer;
    }
}