import java.util.*;

class Solution {
    Map<String, String> map;
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int order = 0, num = 0;
        
        map = new HashMap<>();
        for(int i=10 ; i<16 ; i++){
            String str = "" + (char)('A' + (i - 10));
            map.put(""+i, str);
        }
        
        while(answer.length() < t){
            String value = convert(num++, n);
            for(int i=0 ; i<value.length() ; i++){
                if(order == (p - 1))answer.append(value.charAt(i));
                if(answer.length() == t)break;
                order = (order + 1) % m;
            }
        }
        
        return answer.toString();
    }
    
    private String convert(int num, int n){
        if(num == 0)return "0";
        StringBuilder ret = new StringBuilder();
        while(num > 0){
            String mod = String.valueOf(num % n);
            if(map.containsKey(mod))ret.append(map.get(mod));
            else ret.append(mod);
            num /= n;
        }
        return ret.reverse().toString();
    }
}