import java.io.*;
import java.util.*;

class Main {
    private static final int[] needMatchesCount = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static StringBuilder[] maxDp = new StringBuilder[101];
    private static StringBuilder[] minDp = new StringBuilder[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        maxDp = new StringBuilder[101];
        minDp = new StringBuilder[101];

        minDp[2] = new StringBuilder("1");
        minDp[3] = new StringBuilder("7");
        minDp[4] = new StringBuilder("4");
        minDp[5] = new StringBuilder("2");
        minDp[6] = new StringBuilder("6");
        minDp[7] = new StringBuilder("8");

        maxDp[2] = new StringBuilder("1");
        maxDp[3] = new StringBuilder("7");
        maxDp[4] = new StringBuilder("11");
        maxDp[5] = new StringBuilder("71");
        maxDp[6] = new StringBuilder("111");
        maxDp[7] = new StringBuilder("711");

        for(int total=8 ; total<101 ; total++){

            for(int number=0 ; number<10 ; number++){
                int diff = total - needMatchesCount[number];

                if(minDp[diff] == null)
                    continue;

                StringBuilder temp = new StringBuilder(minDp[diff]);

                if(number == 0){
                    temp.insert(1, "0");
                    
                    if(minDp[total] == null || compare(minDp[total], temp))
                        minDp[total] = temp;

                    continue;
                }

                int idx = 0;
                while(idx < minDp[diff].length() && minDp[diff].charAt(idx) - '0' < number)
                    idx++;

                temp.insert(idx, number);
                if(minDp[total] == null || compare(minDp[total], temp))
                    minDp[total] = temp;

            }

            for(int number=9 ; number>=0 ; number--){
                int diff = total - needMatchesCount[number];

                if(maxDp[diff] == null)
                    continue;

                StringBuilder temp = new StringBuilder(maxDp[diff]);

                int idx = 0;
                while(idx < maxDp[diff].length() && maxDp[diff].charAt(idx) - '0' > number){
                    idx++;
                }

                temp.insert(idx, number);
                if(maxDp[total] == null || !compare(maxDp[total], temp))
                    maxDp[total] = temp;
            }
        }

        StringBuilder answer = new StringBuilder();
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            
            answer.append(minDp[n]).append(" ").append(maxDp[n]).append('\n');    
        }
        
        bw.write(answer.toString());
        bw.close();
        br.close();
    }
    
    private static boolean compare(StringBuilder ori, StringBuilder comp){
        if(ori.length() == comp.length()){
            for(int i=0 ; i<ori.length() ; i++){
                if(ori.charAt(i) > comp.charAt(i))
                    return true;

                if(ori.charAt(i) < comp.charAt(i))
                    return false;
            }
        }

        if(ori.length() > comp.length())
            return true;

        return false;
    }
}
