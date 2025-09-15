import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    static int n, h;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);

        Map<Integer, Integer> up = new HashMap<>();
        Map<Integer, Integer> down = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                up.put(height + 1, up.getOrDefault(height + 1, 0) -1);
            } else {
                down.put(h - height + 1, down.getOrDefault(h - height + 1, 0) + 1);
            }
        }

        int minValue = n, t1 = 0, t2 = 0, cnt = 0;
        for (int i = 0; i < h; i++) {
            if (up.containsKey(i))
                t1 += up.get(i);

            if (down.containsKey(i))
                t2 += down.get(i);

            if (minValue > n / 2 + t1 + t2) {
                minValue = n / 2 + t1 + t2;
                cnt = 1;
            }
            else if(minValue == n / 2 + t1 + t2)
                cnt++;
        }

        System.out.println(minValue + " " + cnt);

        br.close();
    }
}
