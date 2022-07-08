import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a_0708 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] line=line=br.readLine().split(" ");
		long[] num = new long[n];

		for(int i=0;i<n;i++) {
			num[i]=Long.parseLong(line[i]);
		}

		Arrays.sort(num);

		int left = 0;
		int right = n-1;
		
		long temp=0;
		long min=Integer.MAX_VALUE;
		int a = 0,b=0;
		while(left<right) {
			long sum = 0;
			sum=num[left]+num[right];
			temp=Math.abs(sum);
			if(min>temp) {
				min=temp;
				a=left;
				b=right;
			}

			if(sum>0) {
				right--;
			}
			else {
				left++;
			}

		}

		System.out.println(num[a]+" "+num[b]);
	}
}
