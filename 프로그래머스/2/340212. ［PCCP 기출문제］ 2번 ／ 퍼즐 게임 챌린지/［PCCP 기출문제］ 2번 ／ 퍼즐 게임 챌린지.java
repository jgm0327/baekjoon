class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1, right = 100_000;
        
        while(left <= right){
            int level = (left + right) / 2;
            
            long total = 0, prev = 0;
            for(int i=0 ; i<diffs.length ; i++){
                if(level >= diffs[i]){
                    total += times[i];
                }
                else{
                    total += (times[i] + prev) * (long)(diffs[i] - level) + times[i];
                }
                prev = times[i];
            }
            
            if(total <= limit)
                right = level - 1;
            else
                left = level + 1;
            
        }
        return left;
    }
}