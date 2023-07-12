class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left), idx = 0;
        int[] answer = new int[len + 1];
        
        for(long i=left ; i<=right; i++){
            answer[idx++] = Math.max((int)(i/n), (int)(i%n)) + 1;
        }
        return answer;
    }
}