import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class a_0718_new {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[]num = new int[n];
		for(int i=0;i<n;i++) {

			StringTokenizer st1 = new StringTokenizer(br.readLine());	
			num[i]=Integer.parseInt(st1.nextToken());

		}
		Arrays.sort(num);
		int count=1;
		int max=0;
		int maxinde = 0;
		for(int i=1;i<n;i++) {
			if(num[i]==num[i-1]) {
				count++;
			}
			else {
				count=1;
			}
			if(count>max) {
				max=count;
				maxinde=i;
			}
		}
		System.out.println(num[maxinde]);
		
	}

}


