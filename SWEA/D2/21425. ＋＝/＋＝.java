import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
           
            int cnt = 0;
            while(A <= N && B <= N){
                int x = Math.min(A, B);
            	int y = Math.max(A, B);
                
                x += y;
                cnt++;
                
                A = x;
                B = y;
            }
            
            answer.append(cnt).append("\n");
		}
        
        System.out.println(answer);
        br.close();
	}
}