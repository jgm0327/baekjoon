class Solution {
    public int[] solution(int n, int s) {
        if(s < n)
            return new int[]{-1};
        
        int allNumber = s / n;
        int[] answer = new int[n];
        for(int i=0 ; i<n ; i++){
            answer[i] = allNumber;
        }
        
        int div = s - allNumber * n;
        for(int i=n-1 ; i>=0 & div > 0 ; i--){
            answer[i]++;
            div--;
        }
        return answer;
    }
}