import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> nicknames = new HashMap<>();
        
        for(String r : record){
            String[] split = r.split(" ");
            String command = split[0];
            String uid = split[1];
            if("Leave".equals(command))
                continue;
            
            String nickname = split[2];
            
            nicknames.put(uid, nickname);
        }
        
        for(String r : record){
            String[] split = r.split(" ");
            String command = split[0];
            String uid = split[1];
            if("Change".equals(command))
                continue;
            
            StringBuilder temp = new StringBuilder();
            temp.append(nicknames.get(uid)).append("님이 ");
            if("Enter".equals(command))
                temp.append("들어왔습니다.");
            else
                temp.append("나갔습니다.");
            
            answer.add(temp.toString());
        }
        
        return answer.stream().toArray(String[]::new);
    }
}