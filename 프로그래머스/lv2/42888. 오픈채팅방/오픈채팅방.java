import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> members = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(String data : record){
            String[] str = data.split(" ");
            if("Enter".equals(str[0])){
                list.add(new String[]{str[0], str[1]});
                members.put(str[1], str[2]);
            }else if("Leave".equals(str[0])){
                list.add(new String[]{str[0], str[1]});
            }else{
                members.put(str[1], str[2]);
            }
        }
        
        for(String[] data : list){
            if("Enter".equals(data[0])){
                answer.add(members.get(data[1]) + "님이 들어왔습니다.");
            }else{
                answer.add(members.get(data[1]) + "님이 나갔습니다.");
            }
        }
        return answer.toArray(String[]::new);
    }
}