import java.util.Scanner;

public class Main {
	private static int n;
	private static boolean[] visit;
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		visit = new boolean[n + 1];
		recur(0, new StringBuilder());
	}

	private static void recur(int depth, StringBuilder path){
		if(depth == n){
			System.out.println(path);
			return;
		}

		for(int i=1 ; i<=n ; i++){
			if(visit[i])continue;
			visit[i] = true;
			path.append(i);
			path.append(" ");
			recur(depth + 1, path);
			path.delete(path.length() - 2, path.length());
			visit[i] = false;
		}
	}
}
