import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a_0710 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		
		arr[0]=arr[1]=0;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+1;
			
			if(i%3==0) {
				arr[i]= Math.min(arr[i], arr[i/3]+1);
			}
			if(i%2==0) {
				arr[i]= Math.min(arr[i], arr[i/2]+1);
			}
		}
		System.out.println(arr[n]);
	}
}