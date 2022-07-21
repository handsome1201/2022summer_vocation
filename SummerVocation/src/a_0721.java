import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class a_0721 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		list.add(0);
		int num=0;
		for(int i=0;i<n;i++) {
			num=Integer.parseInt(st.nextToken());
			
			if(list.get(list.size()-1)<num) {
				list.add(num);
			}
			else {
				int left=1;
				int right=list.size()-1;
				
				while(left<right) {
					int mid=(right+left)/2;
					if(list.get(mid)<num) {
						left=mid+1;
					}
					else {
						right=mid;
					}
				}
				list.set(right, num);
			}
			
		}
		
		System.out.println(list.size()-1);
	}
}
