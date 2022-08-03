import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a_0803 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n= Integer.parseInt(br.readLine());

		String[] clas = br.readLine().split(" ");
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(clas[i]);
		}
		Arrays.sort(num);

		if (num[0] != 1) {
			System.out.println("1");
		}
		else {
			long sum = num[0];
			for (int i=1; i<n; i++) {
				if (sum+1 < num[i]) {
					System.out.println(sum+1);
					return;
				}
				else {
					sum += num[i];
				}
			}
		}

	}
}
