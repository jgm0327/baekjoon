class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int digit = storey % 10, temp = 0, next = (storey / 10) % 10;
            System.out.println(storey);
            if(digit < 5){
                answer += digit;
            }else if(digit == 5){
                if(next + 1 > 5)
                    temp = 1;
                answer += digit;
            }else{
                answer += (10 - digit);
                temp = 1;
            }
            storey = storey / 10 + temp;
        }
        return answer;
    }
}