import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for(int i=0 ; i<n ; i++){
            int start = commands[i][0] - 1, end = commands[i][1] - 1;
            int[] arr = new int[end - start + 1];
            for(int j=0 ; j<=end-start ; j++){
                arr[j] = array[start + j];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        return answer;
    }
}