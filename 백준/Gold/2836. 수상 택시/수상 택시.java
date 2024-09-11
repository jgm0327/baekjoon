import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        List<int[]> passengerPos = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            if(start <= end)continue;

            passengerPos.add(new int[]{end, start});
        }

        Collections.sort(passengerPos, (o1, o2) -> o1[0] - o2[0]);
        
        int start = 0, end = 0;
        if(!passengerPos.isEmpty()){
            start = passengerPos.get(0)[0];
            end = passengerPos.get(0)[1];
        }

        long answer= 0;

        for(int i=1 ; i<passengerPos.size() ; i++){
            if(end < passengerPos.get(i)[0]){
                answer += (end - start) * 2;

                start = passengerPos.get(i)[0];
                end = passengerPos.get(i)[1];
            }

            end = Math.max(end, passengerPos.get(i)[1]);
        }

        answer += (end - start) * 2;

        bw.write(String.valueOf(answer + m));
        bw.close();
        br.close();
    }
}