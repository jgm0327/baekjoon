import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int answer = 0, idx1 = n - 1;

        while(idx1 > 0 && numbers[idx1] > 0){
            if(numbers[idx1] == 1 
            || (idx1 > 0 && (numbers[idx1 - 1] <= 1))){
                answer += numbers[idx1--];
            }
            else if(idx1 > 0){
                answer += numbers[idx1] * numbers[idx1 - 1];
                idx1 -= 2;
            }
        }

        int idx2 = 0;
        while(idx2 <= idx1){
            if(idx2 + 1 <= idx1){
                answer += numbers[idx2] * numbers[idx2 + 1];
                idx2 += 2;
            }
            else answer += numbers[idx2++];
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}