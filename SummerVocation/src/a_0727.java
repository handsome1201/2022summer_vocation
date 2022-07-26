import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a_0727 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int []a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);


		int result=0;
		for(int i=0;i<a.length;i++) {
			if(i==a.length-2) {
				System.out.println(result+a[i+1]);
				System.exit(0);
			}
			else {
				result=(a[i]+a[i+1])*2;
			}
		}
	}
}
