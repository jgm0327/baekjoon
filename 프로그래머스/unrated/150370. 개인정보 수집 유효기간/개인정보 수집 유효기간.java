import java.util.*;

class Solution {
    final int oneYear = 28*12;
    
    class CustomDate{
        int year, month, day;
        
        public CustomDate(String date){
            String[] str = date.split("\\.");
            this.year = Integer.parseInt(str[0]);
            this.month = Integer.parseInt(str[1]);
            this.day = Integer.parseInt(str[2]);
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();
        CustomDate present = new CustomDate(today);
        
        for(String term : terms){
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        for(int i=0 ; i<privacies.length; i++){
            String[] split = privacies[i].split(" ");
            CustomDate date = new CustomDate(split[0]);
            if(diffDate(present, date) >= map.get(split[1])){
                answer[idx] = i + 1;
                idx++;
            }
        }
        return Arrays.copyOfRange(answer, 0, idx);
    }
    
    private int diffDate(CustomDate today, CustomDate date){
        int ret = 0, minusMonth = 0, minusYear = 0, plusDay=0, plusMonth=0;
        if(today.day < date.day){
            minusMonth = -1;
            plusDay = 28;
        }
        ret += (today.day + plusDay - date.day);
        if(today.month + minusMonth < date.month){
            minusYear = -1;
            plusMonth = 12;
        }
        ret += (today.month + plusMonth + minusMonth - date.month) * 28;
        ret += (today.year + minusYear - date.year) * oneYear;
        return ret;
    }
}