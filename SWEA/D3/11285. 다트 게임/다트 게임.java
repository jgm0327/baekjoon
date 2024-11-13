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
            int totalScore = 0;
            for(int i=0 ; i<n ; i++){
                String[] split = br.readLine().split(" ");
                
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                
                int r = (int)Math.ceil(Math.sqrt(x * x + y * y));
                
                totalScore += getScore(r);
            }
            answer.append("#").append(test_case).append(" ")
                    .append(totalScore).append("\n");
		}
        
        System.out.println(answer);
        br.close();
	}
    
    private static int getScore(int distance){
        if(distance <= 20)
            return 10;
        if(distance <= 40)
            return 9;
        if(distance <= 60)
            return 8;
        if(distance <= 80)
            return 7;
        if(distance <= 100)
            return 6;
        if(distance <= 120)
            return 5;
        if(distance <= 140)
            return 4;
        if(distance <= 160)
            return 3;
        if(distance <= 180)
            return 2;
        if(distance <= 200)
            return 1;
        return 0;
    }
}