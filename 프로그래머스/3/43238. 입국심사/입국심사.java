class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0, right = 100000000000000L;
        
        long[] tempTimes = new long[times.length];
        for(int i=0 ; i<times.length ; i++){
            tempTimes[i] = times[i];
        }
        
        while(left <= right){
            long mid = (left + right) / 2;
            long total = 0;
            
            for(long time : tempTimes){
                total += (mid / time);
            }
            
            if(total >= n){
                right = mid - 1;
                answer = mid;
            }
            
            else left = mid + 1;
        }
        
        return answer;
    }
}