import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
	private static int n, m;
	private static char[] words;
	private static StringBuilder answer;
	private static Map<Character, Boolean> vowels;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		words = new char[m];
		visit = new boolean[m];
		vowels = Map.of('a', true, 'e', true, 'i', true, 'o', true, 'u', true);

		String[] str = br.readLine().split(" ");
		for(int i=0 ; i<m ; i++){
			words[i] = str[i].charAt(0);
		}
		Arrays.sort(words);
		answer = new StringBuilder();

		solution(0, 0, new StringBuilder(), 0);
		System.out.println(answer);
		br.close();
	}

	private static void solution(int depth, int start, StringBuilder path, int count){
		if(depth == n){
			if(count >= 1 && path.length() - count >= 2)
				answer.append(path.toString()).append("\n");
			return;
		}

		for(int i=start ; i<m ; i++){
			if(visit[i])continue;
			visit[i] = true;
			path.append(words[i]);
			if(vowels.containsKey(words[i]))solution(depth + 1, i + 1, path, count + 1);
			else solution(depth + 1, i + 1, path, count);
			path.deleteCharAt(depth);
			visit[i] = false;
		}
	}
}