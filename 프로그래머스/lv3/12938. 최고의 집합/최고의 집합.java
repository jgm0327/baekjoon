class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int data = s / n;
        int[] temp = new int[n];
        // 3 10 3
        // 3 3 4 36
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            temp[i] = data;
            sum += data;
        }
        int t = s - sum;
        for(int i=n-1 ; i>=0 ; i--){
            if(t == 0)break;
            temp[i] += 1;
            t--;
        }
        return data == 0 ? new int[]{-1} : temp;
    }
}