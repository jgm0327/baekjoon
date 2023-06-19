import java.util.*;



class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        int[][] sum = new int[n][n];
        
        for(int i = 0; i < n ; i++){
            sum[i][0] = elements[i];
            for(int j = 1 ; j < n ; j++){
                sum[i][j] += (elements[(i + j) % n] + sum[i][j - 1]);
            }
        }
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                set.add(sum[i][j]);
            }
        }
        return set.size();
    }
}