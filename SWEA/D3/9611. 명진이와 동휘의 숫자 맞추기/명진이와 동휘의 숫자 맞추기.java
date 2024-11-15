import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            sc.nextLine();
            
            boolean[] exist = new boolean[10];
            boolean[] notExist = new boolean[10];
            
            Arrays.fill(exist, true);
            for(int i=0 ; i<n ; i++){
                String[] split = sc.nextLine().split(" ");
                String answer = split[4];
                boolean[] comp = new boolean[10];
                
                for(int j=0 ; j<4 ; j++){
                	int num = Integer.parseInt(split[j]);
                    if(answer.equals("YES")){
                        comp[num] = true;
                    }
                    else
                        notExist[num] = true;
                }
                
                if(!answer.equals("YES"))
                    continue;
                
                for(int num=0 ; num<=9 ; num++){
                    if(comp[num] && exist[num])
                        continue;
                    
                    exist[num] = false;
                }
            }
            
            for(int num=0 ; num<=9 ; num++){
                if(exist[num] && !notExist[num])
                    System.out.println("#" + test_case + " " + num);
            }
		}
	}
}