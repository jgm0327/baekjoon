import java.util.*;

class Solution {
    private ArrayList<int[]> answer;
    
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        return answer.stream().toArray(int[][]::new);
    }
    
    private void hanoi(int n, int left, int mid, int right){
        if(n == 1){
            answer.add(new int[]{left, right});
            return;
        }
        
        hanoi(n - 1, left, right, mid);
        answer.add(new int[]{left, right});
        hanoi(n - 1, mid, left, right);
    }
}