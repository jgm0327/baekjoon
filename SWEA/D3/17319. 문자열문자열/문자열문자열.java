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
		
			int n =Integer.parseInt(br.readLine());
            String str = br.readLine();

            String front = str.substring(0, n / 2);
            String back = str.substring(n / 2, n);
            
            //System.out.println(front + " " + back);
            answer.append("#").append(test_case).append(" ");
            if(front.equals(back))
                answer.append("Yes");
            else
                answer.append("No");
            answer.append("\n");
		}
        
        System.out.print(answer);
	}
}