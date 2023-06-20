import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder builder = new StringBuilder();
        while(n > 0){
            builder.append(""+ (n % k));
            n /= k;
        }
        
        String[] numbers = builder.reverse().toString().split("0");
        
        for(String number : numbers){
            if(number.equals("") || !isPrime(Long.parseLong(number)))continue;
            answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num){
        if(num == 0 || num == 1)return false;
        if(num == 2)return true;
        for(int i=2 ; i<=Math.sqrt(num) ; i++){
            if(num % i == 0)return false;
        }
        return true;
    }
}