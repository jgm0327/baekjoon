import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        
        
        for(String number : phone_book){
            StringBuilder sb = new StringBuilder();
            for(int j=0 ; j<number.length() ; j++){
                sb.append(number.charAt(j));
                if(map.containsKey(sb.toString()))return false;
            }
            map.put(sb.toString(), true);
        }
        return true;
    }
}