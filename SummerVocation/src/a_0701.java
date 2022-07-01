import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_0701 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line =br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if(n==m) {
			System.out.println(0);
		}
		else {
			bfs(n,m);
		}
	}
	static void bfs(int n,int m) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		int[] visited = new int[100000];
		
		visited[n]=1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			int next=0;
			for(int i=0;i<3;i++) {
				if(i==0) {
					next=temp+1;
				}
				else if(i==1) {
					next=temp-1;
				}
				else {
					next=temp*2;
				}
				if(next==m) {
					System.out.println(visited[temp]);
					return;
				}
				if(next>0 && next<visited.length && visited[next]==0) {
					q.add(next);
					visited[next]=visited[temp]+1;
				}
			}
			
			
		}
		
	}
}
