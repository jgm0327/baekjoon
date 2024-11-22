import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //그리디 - 정렬, 뒤에서 보기, 바로 직전 최대 혹은 걍 값 저장해서 사용

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        int[][] holes = new int[n][2];
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            holes[i] = new int[]{start, end};
        }

        Arrays.sort(holes, (o1, o2) -> o1[0] - o2[0]);

        int answer = 0, start = holes[0][0];
        for(int[] hole : holes){
            hole[0] = Math.max(hole[0], start);
            int cnt = (int)Math.ceil((double)(hole[1] - hole[0]) / l);
            answer += cnt;
            start = hole[0] + cnt * l;
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}