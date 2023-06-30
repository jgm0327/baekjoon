class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            answer++;
            for(int i=0 ; i<arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] /= 2;
                    flag = true;
                }
                else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                    flag = true;
                }
            }
        }
        return answer - 1;
    }
}