import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();
        while(true){
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);

            if(n == 0 && m == 0)
                break;

            Map<Integer, Boolean> exist = new HashMap<>();

            for(int i=0 ; i<n ; i++){
                exist.put(Integer.parseInt(br.readLine()), true);
            }

            int count = 0;
            for(int i=0 ; i<m ; i++){
                if(!exist.containsKey(Integer.parseInt(br.readLine())))
                    continue;

                count++;
            }

            answer.append(count).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}