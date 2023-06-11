class Solution {
    String answer;
    public String solution(String new_id) {
        answer = new_id;
        
        stepOne();
        System.out.println(answer);
        stepTwo();
        System.out.println(answer);
        stepThree();
        System.out.println(answer);
        stepFour();
        System.out.println(answer);
        stepFive();
        System.out.println(answer);
        stepSix();
        System.out.println(answer);
        stepSeven();
        System.out.println(answer);
        
        return answer;
    }
    
    private void stepOne(){
        answer = answer.toLowerCase();
    }
    
    private void stepTwo(){
        String change = "";
        for(int i=0 ; i<answer.length() ; i++){
            char ch = answer.charAt(i);
            if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || ch == '.' || ch == '-' || ch == '_')
                change += ch;
        }
        answer = change;
    }
    
    private void stepThree(){
        while(answer.contains("..")){
            answer = answer.replace("..", ".");
        }
    }
    
    private void stepFour(){
        int len = answer.length();
        if(len == 0)return;
        
        if(len >= 2 && answer.charAt(0) == '.' && answer.charAt(len - 1) == '.'){
            answer = answer.substring(1, len - 1);
        }else if(answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }else if(answer.charAt(len - 1) == '.'){
            answer = answer.substring(0, len - 1);
        }
    }
    
    private void stepFive(){
        if(answer.length() == 0)
            answer = "a";
    }
     
    private void stepSix(){
        if(answer.length() >= 16)
            answer = answer.substring(0, 15);
        if(answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, (answer.length() - 1));
        }
    }
    
    private void stepSeven(){
        char last = answer.charAt(answer.length() - 1);
        while(answer.length() < 3){
            answer += last;
        }
    }
}