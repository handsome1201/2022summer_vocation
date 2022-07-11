import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_0711 {
	static int count1=0;
	static int count0=0;
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int n = Integer.parseInt(br.readLine());
	
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine());
			fibonacci(m);
			System.out.println(dp[m][0] + " " + dp[m][1]);
		}
		
	}
	static Integer[] fibonacci(int n) {
	    if (dp[n][0]== null || dp[n][1]== null) {
	    	dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
	    }
	    return dp[n];
	}
}