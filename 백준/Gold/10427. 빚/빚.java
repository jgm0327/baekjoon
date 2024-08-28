import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(T-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            List<Long> arr = new ArrayList<>();
            List<Long> prefix = new ArrayList<>();

            // 01 05 04 03 08
            // 01 06 10 13 21

            prefix.add(0L);
            arr.add(0L);
            int n = Integer.parseInt(tokenizer.nextToken());
            for(int i=1 ; i <= n ; i++){
                arr.add(Long.parseLong(tokenizer.nextToken()));
            }
            
            Collections.sort(arr);
            for(int i=1 ; i<=n ; i++){
                prefix.add(prefix.get(i - 1) + arr.get(i));
            }
            
            long extraFee = 0;

            for(int size=2 ; size<prefix.size() ; size++){
                int left = 1, right = size;
                long minValue = arr.get(right) * size - prefix.get(size);
                // System.out.printf("n: %d, minValue: %d\n", n, minValue);

                if(minValue < 0)minValue = 0;

                while(right + 1< arr.size()){
                    long diff = prefix.get(right + 1) - prefix.get(left);
                    // System.out.printf("size: %d, arr[left]: %d, arr[right]: %d, diff: %d, arr.get(right + 1): %d, minValue: %d\n", size, arr.get(left), arr.get(right), diff, arr.get(right + 1), minValue);
                    minValue = Math.min(minValue, arr.get(right + 1) * size - diff);
                    
                    right++;
                    left++;
                }

                // System.out.printf("minValue: %d, size: %d\n", minValue, size);
                extraFee += minValue;
            }

            answer.append(extraFee).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}