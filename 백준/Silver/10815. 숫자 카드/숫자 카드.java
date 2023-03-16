import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			Map<Integer, Boolean> map = new HashMap<>();
			for(int data : arr)map.put(data, true);
			br.readLine();
			Integer[] target = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
			for(int data : target) {
				int answer = map.containsKey(data) ? 1 : 0;
				System.out.print(answer + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
