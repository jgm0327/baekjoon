class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0, end = 0, len = Integer.MAX_VALUE, sum = 0;
        
        while(start <= end && end < sequence.length){
            // if(sum == k && len > end - start){
            //     len = end - start;
            //     answer[0] = start;
            //     answer[1] = end;
            // }else 
            if(sum + sequence[end] > k){
                sum -= sequence[start];
                if(sum == k && len > end - start){
                    len = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                start++;
            }else{
                sum += sequence[end];
                if(sum == k && len > end - start){
                    len = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
            }
        }
        return answer;
    }
}