import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1, right = distance;
        while(left <= right){
            int mid = (left + right) / 2;
            
            int total = 0, prev = 0;
            for(int i=0 ; i<rocks.length ; i++){
                if(rocks[i] - prev < mid)
                    total++;
                else
                    prev = rocks[i];
            }
            
            if(distance - prev < mid)
                total++;
            
            if(total > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return right;
    }
}