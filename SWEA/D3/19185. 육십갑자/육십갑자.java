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
			String[] split = br.readLine().split(" ");

            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            
            String[] s = br.readLine().split(" ");
            String[] t = br.readLine().split(" ");
            
            int Q = Integer.parseInt(br.readLine());
            
            StringBuilder ret = new StringBuilder();
            while(Q-- > 0){
             	int year = Integer.parseInt(br.readLine()) - 1;
                ret.append(s[year % n]).append(t[year % m]).append(" ");
            }
            
            answer.append("#").append(test_case).append(" ")
                .append(ret).append("\n");
		}
        
        System.out.println(answer);
        br.close();
	}
}