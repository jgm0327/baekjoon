import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{

    private static ArrayDeque<Integer>[] gears;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new ArrayDeque[5];

        for(int i=0 ; i<=4 ; i++){
            gears[i] = new ArrayDeque<>();
        }

        for(int i=1 ; i<=4 ; i++){
            String input = br.readLine();
            for(int j=0 ; j<input.length() ; j++){
                gears[i].add(input.charAt(j) - '0');
            }
        }

        int k = Integer.parseInt(br.readLine());

        while(k-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(tokenizer.nextToken());
            int direction = Integer.parseInt(tokenizer.nextToken());

            turnGears(number, direction);
        }

        int answer = 0, mul = 1;

        for(int i=1 ; i<=4 ; i++){
            answer += gears[i].peek() * mul;
            mul *= 2;
        }
        
        System.out.println(answer);
    }

    private static void turnGears(int number, int direction){

        int tempDir = direction;
        int prevRight = rightLeft(number, false);

        for(int i=number - 1 ; i >= 1 ; i--){

            if(prevRight == rightLeft(i, true)){
                break;
            }

            prevRight = rightLeft(i, false);

            if(tempDir == -1){
                gears[i].addFirst(gears[i].pollLast());
                tempDir = 1;
            }
                
            else{
                gears[i].add(gears[i].poll());
                tempDir = -1;
            }
        }

        tempDir = direction;
        int prevLeft = rightLeft(number, true);
        for(int i=number + 1 ; i <= 4 ; i++){

            if(prevLeft == rightLeft(i, false)){
                break;
            }

            prevLeft = rightLeft(i, true);

            if(tempDir == -1){
                gears[i].addFirst(gears[i].pollLast());
                tempDir = 1;
            }
            
            else{
                gears[i].add(gears[i].poll());
                tempDir = -1;
            }
        }

        if(direction == -1){
            gears[number].add(gears[number].poll());
        }
        else{
            gears[number].addFirst(gears[number].pollLast());
        }
    }

    private static int rightLeft(int number, boolean isRight){
        int cnt = 0, ret = 0;
        
        for(int state : gears[number]){
            cnt++;

            if((isRight && cnt == 3) || (!isRight && cnt == 7)){
                ret = state;
                break;
            }
        }

        return ret;
    }
}