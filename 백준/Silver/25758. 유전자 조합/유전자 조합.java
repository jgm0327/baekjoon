import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        List<int[]>[] list = new ArrayList[26];
        for(int i=0 ; i<26 ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            String str = tokenizer.nextToken();
            list[str.charAt(0) - 'A'].add(new int[]{i, 1});
            list[str.charAt(1) - 'A'].add(new int[]{i, 2});
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<26 ; i++){
            check(i, n, list, answer);
        }

        bw.write(String.valueOf(answer.length() / 2));
        bw.write("\n");
        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static void check(int end, int n, final List<int[]>[] indices, StringBuilder answer){
        for(int i=0 ; i<=end ; i++){
            for(int[] l1 : indices[end]){
                for(int[] l2 : indices[i]){
                    if(l1[0] != l2[0] && ((l1[1] == 1 && l2[1] == 2) || (l1[1] == 2 && l2[1] == 1))){
                        answer.append((char)('A' + end)).append(" ");
                        return;
                    }
                }
            }
        }
    }
}