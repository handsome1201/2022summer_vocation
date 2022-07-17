import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class a_0717_new {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] minus=br.readLine().split("-");
		int[] minusnum = new int[100];
		
		int start=0;
		for(int i=0;i<minus.length;i++) {
			String[] plus = minus[i].split("\\+");
			int result=0;
			for(int j=0;j<plus.length;j++) {
				result+=Integer.parseInt(plus[j]);
			}
			if(i==0) {
				start+=result;
			}
			else {
				start-=result;
			}
			
		}
		System.out.println(start);
		
	}
}
