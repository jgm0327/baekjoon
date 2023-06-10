import java.util.*;

class Solution {
    Map<String, Integer> map;
    
    class CustomDate{
        int year, month, day;
        public CustomDate(String date){
            String[] str = date.split("\\.");
            year = Integer.parseInt(str[0]);
            month = Integer.parseInt(str[1]);
            day = Integer.parseInt(str[2]);
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        List<CustomDate> dates = new ArrayList<>();
        map = new HashMap<>();
        
        //약관 종류와 유효기간 분리
        for(String term : terms){
            String[] data = term.split(" ");
            map.put(data[0], Integer.parseInt(data[1]));
        }
        
        for(String privacy : privacies){
            String[] str = privacy.split(" ");
            CustomDate cur = new CustomDate(str[0]);
            cur.month += map.get(str[1]);
            if(cur.month > 12){
                cur.year += (cur.month / 12);
                cur.month -= (cur.month / 12) * 12;
            }
            dates.add(cur);
        }
        
        CustomDate today2 = new CustomDate(today);
        Date present = new Date(today2.year, today2.month, today2.day);
        
        for(int i=0 ; i<dates.size() ; i++){
            CustomDate cur = dates.get(i);
            Date compare = new Date(cur.year, cur.month, cur.day);
            if(compare.compareTo(present) <= 0)answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(v->v).toArray();
    }
}