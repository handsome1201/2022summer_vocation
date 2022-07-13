import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_0711_new1 {
	static int[] arr=new int[11];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
	
		int n = Integer.parseInt(br.readLine());
		
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine());
			for(int j=4;j<=m;j++) {
				arr[j]=arr[j-3]+arr[j-2]+arr[j-1];
			}
			System.out.println(arr[m]);
			
		}
		
	}
}
