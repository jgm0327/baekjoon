import java.io.*;

class Solution
{
    private static boolean[] visit;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = br.readLine();
            
            visit = new boolean[str.length()];

            String ret = "impossible\n";
            if(dfs(new StringBuilder(), str))
                ret = "possible\n";
            
            answer.append("#").append(test_case).append(" ").append(ret);
		}
        
        System.out.println(answer);
        br.close();
	}
    
    private static boolean dfs(StringBuilder path, String number){
        if(path.length() == number.length()){
            int n = Integer.parseInt(number);
            int k = Integer.parseInt(path.toString()); 
            if(n < k && k % n == 0)
                return true;
            
            return false;
        }
        
        for(int i=0 ; i<number.length() ; i++){
        	if(visit[i])
                continue;
            
            visit[i] = true;
            path.append(number.charAt(i));
            
            if(dfs(path, number))
                return true;
            
            path.deleteCharAt(path.length() - 1);
            visit[i] = false;
        }
        
        return false;
    }
}