import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 1, right = 1_000_000_000;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int prev = 0, cnt = 0;
            for(int rock : rocks) {
                if(rock - prev < mid){
                    cnt++;
                    continue;
                }
                prev = rock;
            }
            
            if(distance - prev < mid)
                cnt++;
            
            if(cnt > n)
                right = mid - 1;
            else left= mid + 1;
        }
        
        return right;
    }
}