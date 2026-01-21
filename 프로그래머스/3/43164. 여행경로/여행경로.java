import java.util.*;

class Solution {
    class Ticket implements Comparable<Ticket>{
        String des;
        int idx;
        
        public Ticket(String des, int idx){
            this.des = des;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Ticket o){
            return this.des.compareTo(o.des);
        }
    }
    
    Map<String, List<Ticket>> customTickets;
    List<String> answer;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        customTickets = new HashMap<>();
        
        for(int i=0 ; i<tickets.length ; i++){
            String[] ticket = tickets[i];
            
            if(!customTickets.containsKey(ticket[0]))
                customTickets.put(ticket[0], new ArrayList<>());
            
            customTickets.get(ticket[0]).add(new Ticket(ticket[1], i));
        }
        
        for(String key : customTickets.keySet()){
            Collections.sort(customTickets.get(key));
        }
        
        ArrayDeque<String> path = new ArrayDeque<>();
        path.add("ICN");
        dfs("ICN", new boolean[tickets.length], path, tickets.length);
        
        return answer.stream().toArray(String[]::new);
    }
    
    void dfs(String sour, boolean[] visit, ArrayDeque<String> path, int n){
        if(n == 0){
            answer = new ArrayList<>(path);
            return;
        }
        
        if(!customTickets.containsKey(sour))
            return;
        
        for(Ticket ticket : customTickets.get(sour)){
            if(visit[ticket.idx])
                continue;
            
            visit[ticket.idx] = true;
            path.add(ticket.des);
            
            dfs(ticket.des, visit, path, n - 1);
            if(answer.size() != 0)
                return;
            
            path.pollLast();
            visit[ticket.idx] = false;
        }
    }
}