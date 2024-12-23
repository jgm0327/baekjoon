class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int end = convertToInt(video_len);
        int pos_int = convertToInt(pos);
        int op_start_int = convertToInt(op_start);
        int op_end_int = convertToInt(op_end);
        
        for(String command : commands){
            if(op_start_int <= pos_int && pos_int <= op_end_int)
                pos_int = op_end_int;
            
            if(command.equals("prev")){
                pos_int -= 10;
                pos_int = Math.max(pos_int, 0);
            }
            else{
                pos_int += 10;
                pos_int = Math.min(pos_int, end);
            }
        }
        if(op_start_int <= pos_int && pos_int <= op_end_int)
                pos_int = op_end_int;
        
        
        int hour = pos_int / 60;
        int minute = pos_int % 60;
        
        String answer = "";
        if(hour <= 9)
            answer += '0';
        answer+=hour;
        answer+=":";
        if(minute <= 9)
            answer += '0';
        answer+=minute;
        
        return answer;
    }
    
    private int convertToInt(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        return hour * 60 + minute;
    }
}