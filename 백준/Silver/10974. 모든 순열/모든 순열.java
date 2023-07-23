import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	private static int n;
	private static boolean[] visit;
	private static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		Scanner sc  = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = sc.nextInt();
		visit = new boolean[n + 1];
		recur(0, new StringBuilder());
		bw.flush();
		bw.close();
	}

	private static void recur(int depth, StringBuilder path) throws IOException{
		if(depth == n){
			bw.write(path.toString() + "\n");
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
