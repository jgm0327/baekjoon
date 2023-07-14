import java.util.Arrays;

class Solution {
    private class FileName implements Comparable<FileName>{
        String head, number, tail;
        public FileName(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(FileName o){
            if(this.head.compareToIgnoreCase(o.head) > 0)return 1;
            else if(this.head.compareToIgnoreCase(o.head) < 0)return -1;
            if(Integer.parseInt(o.number) < Integer.parseInt(this.number))
                return 1;
            else if(Integer.parseInt(o.number) > Integer.parseInt(this.number))
                return -1;
            return 0;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileName[] filenames = new FileName[files.length];
        for(int i=0 ; i<files.length ; i++){
            String file = files[i];
            int idx = 0;
            filenames[i] = new FileName(null, null, null);
            // get Head
            StringBuilder head = new StringBuilder();
            while(idx < file.length() && !isDigit(file.charAt(idx))){
                head.append(file.charAt(idx++));
            }
            filenames[i].head = head.toString();
            
            // get number
            StringBuilder number =  new StringBuilder();
            while(idx < file.length() && isDigit(file.charAt(idx))){
                number.append(file.charAt(idx++));
            }
            filenames[i].number = number.toString();
            
            // get tail
            filenames[i].tail = file.substring(idx);
        }
        Arrays.sort(filenames);
        
        for(int i=0 ; i<filenames.length ; i++){
            answer[i] = filenames[i].head + filenames[i].number + filenames[i].tail;
        }
        
        return answer;
    }
    
    private boolean isDigit(char num){
        return '0' <= num && num <= '9';
    }
}