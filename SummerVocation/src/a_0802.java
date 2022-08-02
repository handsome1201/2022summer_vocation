import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class a_0802 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] clas = br.readLine().split("");
		int count1=0;
		int count0=0;
		Stack<String> st = new Stack<>();
		st.add(clas[0]);
		count1++;
		
		for(int i=1;i<clas.length;i++) {
			if(!clas[i].equals(st.peek()) && clas[0].equals(clas[i])) {
				count1++;
				st.push(clas[i]);
			}
			else if(!clas[i].equals(st.peek()) && !clas[0].equals(clas[i])) {
				count0++;
				st.push(clas[i]);
			}
			else {
				st.push(clas[i]);
			}
		}
		if(count1>count0) {
			System.out.println(count0);
		}
		else {
			System.out.println(count1);
		}
		
		
		
		
	}
}