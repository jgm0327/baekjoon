import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            
            int[] costs = new int[n * 2];
            for(int i=0 ; i<n*2 ; i++)
                costs[i] = Integer.parseInt(tokenizer.nextToken());
            
            StringBuilder discountCosts = new StringBuilder();
            Map<Integer, Integer> exist = new HashMap<>();
            for(int i=0 ; i<n*2; i++){
                int discount = (costs[i] / 4) * 3;
                
                if(costs[i] % 4 == 0 && exist.getOrDefault(discount, 0) > 0){
                    discountCosts.append(discount).append(" ");
                    exist.put(discount, exist.get(discount) - 1);
                    continue;
                }
      
                exist.put(costs[i], exist.getOrDefault(costs[i], 0) + 1);
            }
            
            answer.append("#").append(test_case).append(" ")
                .append(discountCosts).append("\n");
		}
        
        System.out.println(answer);
	}
}