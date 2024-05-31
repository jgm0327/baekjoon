import java.util.*;

class Solution {
    class Assignment implements Comparable<Assignment>{
        String name;
        int startTime;
        int duration;
        
        public Assignment(String name, String startTime, String duration){
            this.name = name;
            this.startTime = calculateTime(startTime);
            this.duration = Integer.parseInt(duration);
        }
        
        private int calculateTime(String startTime){
            String[] split = startTime.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            
            return hour * 60 + minute;
        }
        
        @Override
        public int compareTo(Assignment o){
            return this.startTime - o.startTime;
        }
        
        @Override
        public String toString(){
            return this.name + " " + this.startTime + " " + this.duration;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        List<Assignment> assignments = new ArrayList<>();
        for(String[] plan : plans){
            assignments.add(new Assignment(plan[0], plan[1], plan[2]));
        }
        
        Collections.sort(assignments);
        ArrayDeque<Assignment> stack = new ArrayDeque<>();
        
        int prev = 0;
        int idx = 0;
        
        for(Assignment assignment : assignments){
            int startTime = assignment.startTime, duration = assignment.duration;
            String name = assignment.name;
            
            while(!stack.isEmpty()
                  && prev + stack.peekLast().duration <= startTime){
                prev += stack.peekLast().duration;
                answer[idx++] = stack.pollLast().name;
            }
            
            if(!stack.isEmpty()){
                stack.peekLast().duration = 
                    prev + stack.peekLast().duration - startTime;
            }
            
            prev = startTime;
            stack.add(assignment);
        }
        
        while(!stack.isEmpty()){
            answer[idx++] = stack.pollLast().name;
        }
        
        return answer;
    }
}