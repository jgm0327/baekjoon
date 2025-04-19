class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1, right = (long)1e18 + 1;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long total = 0;
            for(int time : times){
                total += mid / time;
            }
            
            // System.out.println(total + " " + mid);
            
            if(total >= n){
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return left;
    }
}