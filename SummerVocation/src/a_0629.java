import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_0629 {
	static int[][] node;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		int m =Integer.parseInt(br.readLine());

		
		node = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			String line =br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int head = Integer.parseInt(st.nextToken());
			int tail = Integer.parseInt(st.nextToken());
			
			node[head][tail]=1;
			node[tail][head]=1;
		}
		bfs(1);
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n);
		visited[n]=true;
		int count=0;
		
		while(!q.isEmpty()) {
			int num=q.poll();
			
			for(int i=0;i<node.length;i++) {
				if(node[num][i]==1 && !visited[i]) {
					visited[i]=true;
					q.offer(i);
					count++;
				}
			}
			
		}
		System.out.println(count);
	}

}
