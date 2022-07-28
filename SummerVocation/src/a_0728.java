import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class a_0728 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> minus = new ArrayList<Integer>();
		ArrayList<Integer> plus = new ArrayList<Integer>();
		int[] a = new int[50];
		int g=0;
		for(int i=0;i<n;i++) {
			int t = Integer.parseInt(br.readLine());
			if(t<=0) {
				minus.add(t);
			}
			else if(t==1) {
				g++;
			}
			else if(t>1){
				plus.add(t);
			}
		}
		Collections.sort(minus);
		Collections.sort(plus);
		int result=0;
		if(minus.size()%2==0) {
			for(int i=0;i<minus.size()-1;i++) {
				result+=minus.get(i)*minus.get(i+1);
				i++;
			}
		}
		else {
			for(int i=0;i<minus.size()-1;i++) {
				result+=minus.get(i)*minus.get(i+1);
				i++;
			}
			result+=minus.get(minus.size()-1);
		}
		if(plus.size()%2==0) {
			for(int i=plus.size()-1;i>=1;i--) {
				result+=plus.get(i)*plus.get(i-1);
				i--;
			}
		}
		else {
			for(int i=plus.size()-1;i>=1;i--) {
				result+=plus.get(i)*plus.get(i-1);
				i--;
			}
			result+=plus.get(0);
		}
		if(g!=0) {
			System.out.println(result+g);
		}
		else {
			System.out.println(result);
		}

	}
}
