import java.io.*;
import java.util.*;

class Main{
    private static int n, m;
    private static int[] numbers;
    private static StringBuilder answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for(int i=0 ; i<n ; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(numbers);
        answer = new StringBuilder();
        dfs(0, new ArrayDeque<>());
        
        bw.write(answer.toString());
		bw.close();
		br.close();
	}

    private static void dfs(int start, ArrayDeque<Integer> path){
        if(path.size() == m){
            for(int number : path){
                answer.append(number).append(' ');
            }
            answer.append('\n');
            return;
        }

        for(int i=0; i<n ; i++){

            path.add(numbers[i]);
            dfs(i + 1, path);
            path.pollLast();
        }
    }

}