import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> asc = new PriorityQueue<>();
        Queue<Integer> desc = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(String op : operations){
            String[] str = op.split(" ");
            int number = Integer.parseInt(str[1]);
            
            if("I".equals(str[0])){
                asc.add(number);
            }else if("D".equals(str[0])){
                if(number == 1){
                    while(!asc.isEmpty()){
                        desc.add(asc.poll());
                    }
                    desc.poll();
                }else if(number == -1){
                    while(!desc.isEmpty()){
                        asc.add(desc.poll());
                    }
                    asc.poll();
                }
            }
        }
        
        
        int min = 0, max = 0;
        if(!asc.isEmpty()){
            min = asc.poll();
            while(asc.size() > 1){
                asc.poll();
            }
            max = asc.isEmpty() ? min : asc.poll();
        }
        
        if(!desc.isEmpty()){
            min = desc.poll();
            while(desc.size() > 1){
                desc.poll();
            }
            max = desc.isEmpty() ? min : desc.poll();
        }
        
        return new int[]{Math.max(min, max), Math.min(min, max)};
    }
}