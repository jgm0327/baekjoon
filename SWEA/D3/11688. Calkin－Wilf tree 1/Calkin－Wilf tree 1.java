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
			String str = br.readLine();
            
            int a = 1, b = 1;
            for(int i=0 ; i<str.length() ; i++){
                if(str.charAt(i) == 'L')
                    b += a;
                else
                    a += b;
            }

            answer.append("#").append(test_case).append(" ")
                .append(a).append(" ").append(b).append('\n');
		}
        
        System.out.println(answer);
        br.close();
	}
}