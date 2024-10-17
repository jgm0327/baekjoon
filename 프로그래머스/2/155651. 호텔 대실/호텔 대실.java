import java.util.*;

class Solution {
    class BookTime implements Comparable<BookTime>{
        int start, end;
        
        public BookTime(String time1, String time2){
            this.start = convertToInt(time1);
            this.end = convertToInt(time2);
        }
        
        private int convertToInt(String time){
            String[] split = time.split(":");
            
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        
        @Override
        public int compareTo(BookTime o){
            if(this.start != o.start)
                return this.start - o.start;
            
            return this.end - o.end;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<BookTime> times = new ArrayList<>();
        for(String[] time : book_time){
            times.add(new BookTime(time[0], time[1]));
        }
        
        Collections.sort(times);
        
        List<ArrayDeque<BookTime>> rooms = new ArrayList<>();
        
        for(BookTime time : times){
            int start = time.start;
            
            time.end += 10;
            
            boolean needMoreRoom = true;
            for(ArrayDeque<BookTime> room : rooms){
                if(room.peekLast().end <= start){
                    needMoreRoom = false;
                    room.add(time);
                    break;
                }
            }
            
            if(needMoreRoom){
                ArrayDeque<BookTime> moreRoom = new ArrayDeque<>();
                moreRoom.add(time);
                rooms.add(moreRoom);
            }
        }
        
        return rooms.size();
    }
}