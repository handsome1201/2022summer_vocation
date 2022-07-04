import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class locati{
	int x, y;

	public locati(int x,int y) {
		this.x=x;
		this.y=y;
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
public class a_0704 {
	static int[][] graph;
	static int[] dx = {1, 0 , -1, 0};       // ªÛ«œ¡¬øÏ ∞ËªÍ«“ x¡¬«•
	static int[] dy = {0, 1, 0, -1}; 
	static int[][] visited;
	static int n,m;
	static Queue<locati> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line =br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[m][n];
		visited = new int[m][n];
		
		q = new LinkedList<locati>();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				if(graph[i][j]==1) {
					q.offer(new locati(j, i));
				}
			}
		}
		bfs();
	}

	static void bfs() {
		while(!q.isEmpty()){
			locati temp = q.poll();

			for(int i=0;i<4;i++) {
				int xx = temp.getX() + dx[i];
				int yy = temp.getY() + dy[i];

				if(yy>=m || yy<0 || xx>=n || xx < 0) {
					continue;
				}
				if(graph[yy][xx]==0) {
					q.offer(new locati(xx,yy));
					graph[yy][xx]=graph[temp.getY()][temp.getX()]+1;
				}
			}
		}
		int max=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(graph[i][j]==0) {
					System.out.println("-1");
					System.exit(0);
				}
				if(max<graph[i][j]) {
					max=graph[i][j];
				}
			}
		}
		if(max==1) {
			System.out.println("0");
		}
		else {
			System.out.println(max-1);
		}
	}
}