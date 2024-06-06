class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = {0, n};
        int left = 0, right = 0, total = 0;
        
        while(left <= right && left < n){
            if(right < n && total + sequence[right] <= k){
                total += sequence[right];
                check(answer, right, left, k, total);
                right++;
            }
            else {
                total -= sequence[left];
                check(answer, right, left, k, total);
                left++;
            }
        }
        return answer;
    }
    
    private void check(int[] answer, int right, int left, int k, int total){
        if(total != k || right - left >= answer[1] - answer[0])
            return;
        
        answer[0] = left;
        answer[1] = right;
    }
}