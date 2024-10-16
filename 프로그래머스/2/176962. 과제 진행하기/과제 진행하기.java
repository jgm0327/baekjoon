import java.util.*;

class Solution {
    class Subject implements Comparable<Subject>{
        String name;
        int start, duration;
        
        public Subject(String name, String time, int duration){
            this.name = name;
            this.start = convertToInt(time);
            this.duration = duration;
        }
        
        private int convertToInt(String time){
            String[] split = time.split(":");
            
            return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }
        
        @Override
        public int compareTo(Subject o){
            return this.start - o.start;
        }
        
        @Override
        public String toString(){
            return this.name + " " + this.duration;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        List<Subject> subjects = new ArrayList<>();
        for(String[] plan : plans){
            subjects.add(new Subject(plan[0], plan[1], Integer.parseInt(plan[2])));
        }
        
        Collections.sort(subjects);
        ArrayDeque<Subject> pause = new ArrayDeque<>();
        int cur = 0, idx = 0;
        for(int i=0 ; i<subjects.size() ; i++){
            while(!pause.isEmpty() && cur + pause.peekLast().duration <= subjects.get(i).start){
                cur += pause.peekLast().duration;
                answer[idx++] = pause.pollLast().name;
            }
            
            if(!pause.isEmpty()){
                pause.peekLast().duration -= (subjects.get(i).start - cur);
            }
            cur = subjects.get(i).start;
            pause.add(subjects.get(i));
        }
        
        while(!pause.isEmpty()){
            answer[idx++] = pause.pollLast().name;
        }
        
        return answer;
    }
}