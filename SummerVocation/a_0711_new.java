import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_0711_new {
	static int count1=0;
	static int count0=0;
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[1][0]=0;
		dp[1][1]=1;
		dp[0][0]=1;
		dp[0][1]=0;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine());
			fibonacci(m);
			System.out.println(dp[m][0] + " " + dp[m][1]);
		}

	}
	
	static Integer[] fibonacci(int m) {
		if(dp[m][0]==null || dp[m][1]==null) {
			dp[m][0]=fibonacci(m-1)[0]+fibonacci(m-2)[0];
			dp[m][1]=fibonacci(m-1)[1]+fibonacci(m-2)[1];
		}
		return dp[m];
	}
}
