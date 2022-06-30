import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_0630 {
	static int[][] Node;
	static boolean[][] visited;
	static int[] x = {1,0,-1,0};
	static int[] y = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n =Integer.parseInt(br.readLine());
		for(int t=0;t<n;t++) {
			String line = br.readLine();

			StringTokenizer st = new StringTokenizer(line);

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Node = new int[N][M];
			visited = new boolean[N][M];
			int count = 0;

			for(int i=0;i<K;i++) {
				String line1 = br.readLine();

				StringTokenizer str = new StringTokenizer(line1);

				int lox = Integer.parseInt(str.nextToken());
				int loy = Integer.parseInt(str.nextToken());

				Node[loy][lox]=1;
			}

			loc lo;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited[i][j] && Node[i][j]==1) {
						lo = new loc(j,i);
						bfs(visited,Node,N,M,lo);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}
	public static void bfs(boolean[][] visited, int[][] Node, int N,int M, loc lo) {
		Queue<loc> q = new LinkedList<>();
		q.offer(lo);
		int count=0;
		visited[lo.getY()][lo.getX()]=true;

		while(!q.isEmpty()) {
			loc lo1 = q.poll();
			count++;

			for(int i=0;i<4;i++) {
				int xx = lo1.getX()+x[i];
				int yy = lo1.getY()+y[i];

				if(yy>=N || yy<0 || xx>=M || xx < 0) {
					continue;
				}
				if(visited[yy][xx]) {
					continue;
				}
				if(Node[yy][xx]==1 && !visited[yy][xx]) {
					visited[yy][xx]=true;
					q.offer(new loc(xx,yy));

				}
			}
		}
	}
}
class loc{
	int x, y;

	public loc(int x, int y){
		super();
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
