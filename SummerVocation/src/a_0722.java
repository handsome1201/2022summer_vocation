import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a_0722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] bot = new int[m + 2];
		int[] top = new int[m + 2];
		for(int i=0;i<n/2;i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[m - Integer.parseInt(br.readLine()) + 1]++;
		}
		for (int i = 1; i <= m; i++) {
			bot[i] += bot[i - 1];
		}

		for (int i = m; i >= 1; i--) {
			top[i] += top[i + 1];
		}
		int min=n;
		int countnum=0;
		for(int i=1;i<=m;i++) {
			int obs = (bot[m] - bot[i - 1]) + (top[1] - top[i + 1]);

			if (obs < min) {
				min = obs;
				countnum = 1;
			} else if (obs == min)
				countnum++;
		}
		System.out.println(min+" "+countnum);
	
	}
}
