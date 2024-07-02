class Solution {
    public int solution(int n) {
        return convertDecimal(convertTrinaryDigit(n));
    }
    
    private String convertTrinaryDigit(int n){
        StringBuilder ret = new StringBuilder();
        
        while(n > 0){
            ret.append(n % 3);
            n /= 3;
        }
        
        return ret.toString();
    }
    
    private int convertDecimal(String number){
        int ret = 0, mul = 1;
        for(int i=number.length() - 1 ; i>=0 ; i--){
            ret += (number.charAt(i) - '0') * mul;
            mul *= 3;
        }
        return ret;
    }
}