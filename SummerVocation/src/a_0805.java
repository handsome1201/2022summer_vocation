import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class a_0805 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		String[] b = new String[n];
		b=br.readLine().split("");
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(b[i]);
		}
		int count=0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++) {		
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && count < m) {
					if (stack.peek() < a[i]) {
						stack.pop();
						count++;
					} else {
						break;
					}
				}
			}

			stack.push(a[i]);
			

		}
		Stack<Integer> stack1 = new Stack<Integer>();
		while(!stack.empty()) {
			stack1.push(stack.pop());
		}
		for(int i=0;i<n-m;i++) {
			System.out.print(stack1.pop());
		}
	}
}
