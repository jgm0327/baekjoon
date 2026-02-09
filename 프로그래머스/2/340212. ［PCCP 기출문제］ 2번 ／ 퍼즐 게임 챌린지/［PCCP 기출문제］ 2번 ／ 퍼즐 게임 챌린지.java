class Solution {
    // 풀이 14분
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        long left = 1, right = 100_000;
        while(left <= right){
            long level = (left + right) / 2;
            
            long total = 0, prev = 0;
            for(int i=0 ; i<times.length ; i++){
                if(diffs[i] > level)
                    total += (diffs[i] - level) * (prev + times[i]) + times[i];
                else
                    total += times[i];
                
                prev = times[i];
            }
            
            if(total > limit)
                left = level + 1;
            else right = level - 1;
        }
        
        
        return (int)left;
    }
}