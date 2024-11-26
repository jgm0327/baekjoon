import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] count = new int[10];
        for(int i=0 ; i<str.length() ; i++){
            int number = str.charAt(i) - '0';
            count[number]++;
        }

        String subtract = br.readLine();
        int[] subCount = new int[10];
        for(int i=0 ; i<subtract.length() ; i++){
            int number = subtract.charAt(i) - '0';
            subCount[number]++;
        }

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=0 ; i<str.length() ; i++){
            int number = str.charAt(i) - '0';

            if(subCount[number] > 0 && count[number] == subCount[number]){
                subCount[number]--;
                count[number]--;
                continue;
            }

            while(!stk.isEmpty() && stk.peekLast() < number){
                if(subCount[stk.peekLast()] == 0)
                    break;

                subCount[stk.peekLast()]--;
                stk.pollLast();
            }

            count[number]--;
            stk.add(number);
        }

        StringBuilder answer = new StringBuilder();
        while(!stk.isEmpty()){
            answer.append(stk.poll());
        }
        
        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}