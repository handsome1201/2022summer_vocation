import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_0701_2 {
	static int[][] node;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line =br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		node = new int[n+1][n+1];
		visited = new boolean[n+1];
		int count=0;
		
		for(int i=0;i<m;i++) {
			line =br.readLine();
			st = new StringTokenizer(line);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			node[start][end]=1;
			node[end][start]=1;
		}
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visited[i]=true;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			for(int k=1;k<=n;k++) {
				if(!visited[k] && node[temp][k]==1) {
					visited[k]=true;
					q.offer(k);
				}
			}
		}
	}
}
