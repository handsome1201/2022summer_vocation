import java.util.*;
import java.io.*;


class X_1{
	int x, y;

	public X_1(int x, int y){
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
public class a_0628_again {

	static int[][] graph;
	static int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
	static int[] dy = {0, 1, 0, -1}; 
	static ArrayList<Integer> cnt = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n =Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] num = br.readLine().split("");
			for(int j=0;j<n;j++) {
				graph[j][i]=Integer.parseInt(num[j]);
			}
		}
		boolean[][] visited=new boolean[n][n]; //방문 여부 확인
		X_1 lo;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[j][i] && graph[j][i]==1) {
					lo = new X_1(i,j); // 좌표값 저장
					bfs(visited,graph,lo,n);
				}
			}
		}
		
		System.out.println(cnt.size());
		Collections.sort(cnt);
		for(int i=0;i<cnt.size();i++) {
			System.out.println(cnt.get(i));
		}
		
	}
	static void bfs(boolean[][] visited,int[][] graph, X_1 lo,int n) {
		Queue<X_1> q = new LinkedList<>();
		int count=0;
		q.offer(lo); //시작 위치를 q에 넣어줌
		visited[lo.getY()][lo.getX()]=true;
		
		while(!q.isEmpty()) {
			X_1 loc = q.poll();
			count++;
			for(int i=0;i<4;i++) {
				int xx=loc.getX()+dx[i];
				int yy=loc.getY()+dy[i];
				
				if(yy>=n || yy<0 || xx>=n || xx < 0) 
					continue;
				
				if(visited[yy][xx]) 
					continue;
				
				if(!visited[yy][xx] && graph[yy][xx]==1) {
					visited[yy][xx]=true;
					q.offer(new X_1(xx,yy));
				}
			}
			
		}
		cnt.add(count);
	}
}
