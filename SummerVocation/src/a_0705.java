import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_0705 {
	static int n;
	static String[][] node;
	static boolean[][] visited;
	static int[] dx = {1, 0 , -1, 0};       // ªÛ«œ¡¬øÏ ∞ËªÍ«“ x¡¬«•
	static int[] dy = {0, 1, 0, -1};        // ªÛ«œ¡¬øÏ ∞ËªÍ«“ y¡¬«•
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		node = new String[n][n];
		visited = new boolean[n][n];
		int cnt = 0;

		for(int i=0;i<n;i++){
			String[] line = br.readLine().split("");
			for(int j=0;j<n;j++)
			{
				node[i][j] = line[j];
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && node[i][j].equals("R")) {
					bfsR(j,i);
					cnt++;
				}
				else if(!visited[i][j] && node[i][j].equals("G")){
					bfsG(j,i);
					cnt++;
				}
				else if(!visited[i][j] && node[i][j].equals("B")){
					bfsB(j,i);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		visited = new boolean[n][n];
		cnt=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(node[i][j].equals("G")) {
					node[i][j]="R";
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && node[i][j].equals("R")) {
					bfsR(j,i);
					cnt++;
				}
				else if(!visited[i][j] && node[i][j].equals("B")){
					bfsB(j,i);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	static void bfsR(int x,int y) {
		Queue<loca> q = new LinkedList<>();
		q.offer(new loca(x,y));

		visited[y][x]=true;

		while(!q.isEmpty()) {
			loca lo1 = q.poll();


			for(int i=0;i<4;i++) {
				int xx = lo1.getX()+dx[i];
				int yy = lo1.getY()+dy[i];

				if(yy>=n || yy<0 || xx>=n || xx < 0) {
					continue;
				}
				if(visited[yy][xx]) {
					continue;
				}
				if(node[yy][xx].equals("R") && !visited[yy][xx]) {
					visited[yy][xx]=true;
					q.offer(new loca(xx,yy));
				}
			}
		}
	}
	static void bfsG(int x,int y) {
		Queue<loca> q = new LinkedList<>();
		q.offer(new loca(x,y));

		visited[y][x]=true;

		while(!q.isEmpty()) {
			loca lo1 = q.poll();


			for(int i=0;i<4;i++) {
				int xx = lo1.getX()+dx[i];
				int yy = lo1.getY()+dy[i];

				if(yy>=n || yy<0 || xx>=n || xx < 0) {
					continue;
				}
				if(visited[yy][xx]) {
					continue;
				}
				if(node[yy][xx].equals("G") && !visited[yy][xx]) {
					visited[yy][xx]=true;
					q.offer(new loca(xx,yy));
				}
			}
		}
	}
	static void bfsB(int x,int y) {
		Queue<loca> q = new LinkedList<>();
		q.offer(new loca(x,y));

		visited[y][x]=true;

		while(!q.isEmpty()) {
			loca lo1 = q.poll();


			for(int i=0;i<4;i++) {
				int xx = lo1.getX()+dx[i];
				int yy = lo1.getY()+dy[i];

				if(yy>=n || yy<0 || xx>=n || xx < 0) {
					continue;
				}
				if(visited[yy][xx]) {
					continue;
				}
				if(node[yy][xx].equals("B") && !visited[yy][xx]) {
					visited[yy][xx]=true;
					q.offer(new loca(xx,yy));
				}
			}
		}
	}
}
