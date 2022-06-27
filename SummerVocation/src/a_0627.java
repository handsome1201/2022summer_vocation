import java.util.*;
import java.io.*;

public class a_0627 {
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		StringTokenizer st = new StringTokenizer(line);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				graph[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
		int[] dy = {0, 1, 0, -1};        // 상하좌우 계산할 y좌표

		Queue<Pair> q = new LinkedList<>();

		boolean[][] visited = new boolean[n+1][m+1];

		q.offer(new Pair(1,1));
		visited[1][1]=true;

		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0;i<dx.length;i++) {
				int xx = p.x+dx[i];
				int yy = p.y+dy[i];
				if(xx>0 && yy>0 && xx<=m  && yy<=n) {
					if(graph[yy][xx] !=0 && !visited[yy][xx]) {
						visited[yy][xx]=true;
						graph[yy][xx] = graph[p.y][p.x] + 1;
						q.add(new Pair(xx,yy));
					}
				}
			}
		}
		System.out.println(graph[n][m]);
	}
}
// 큐에 좌표를 넣어주기 위한 클래스
class Pair{
	int x, y;

	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}


