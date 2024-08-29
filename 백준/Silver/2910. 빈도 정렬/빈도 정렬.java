import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int[][] numbers = new int[n + 1][2];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            int number = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = new int[]{number, i};
        }
        
        Arrays.sort(numbers, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> count = new ArrayList<>();
        int idx = -1;

        for(int i=1 ; i<=n ; i++){
            if(numbers[i][0] != numbers[i - 1][0])idx++;

            if(count.size() == idx){
                count.add(new int[]{numbers[i][0], 1, numbers[i][1]});
            }
            else{
                int[] a = count.get(idx);
                a[1]++;
                a[2] = Math.min(a[2], numbers[i][1]);
            }
        }

        Collections.sort(count, (o1, o2) -> {
            if(o2[1] != o1[1]) return o2[1] - o1[1];
            return o1[2] - o2[2];
        });

        StringBuilder answer = new StringBuilder();
        for(int[] s : count){
            for(int i=0 ; i<s[1] ; i++)
                answer.append(s[0]).append(" ");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}