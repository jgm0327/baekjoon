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
            
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            
            tokenizer = new StringTokenizer(br.readLine());
            int[] candies = new int[n];
            for(int i=0 ; i<n ; i++)
                candies[i] = Integer.parseInt(tokenizer.nextToken());
            
            Arrays.sort(candies);
            int left = 0, right = k - 1, minDiff = candies[right] - candies[left];
            while(right < n){
                minDiff = Math.min(candies[right++] - candies[left++], minDiff);
            }
			
            answer.append("#").append(test_case).append(" ")
                .append(minDiff).append("\n");
		}
        
        System.out.println(answer);
        br.close();
	}
}