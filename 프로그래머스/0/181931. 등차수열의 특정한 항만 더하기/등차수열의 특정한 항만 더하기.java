class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for(int i=0 ; i<included.length ; i++){
            int sum = a + d * i;
            if(included[i]){
                answer += sum;
            }
        }
        
        return answer;
    }
}