import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        
		Map<Character, Character> reflect = new HashMap<>();
        reflect.put('p', 'q');
        reflect.put('q', 'p');
        reflect.put('b', 'd');
        reflect.put('d', 'b');
        
        StringBuilder answer = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = br.readLine();
            answer.append("#").append(test_case).append(" ");
            for(int i=str.length() - 1 ; i>=0 ; i--)
                answer.append(reflect.get(str.charAt(i)));
            
            answer.append("\n");
		}
        
        System.out.println(answer);
	}
}