import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class a_0628 {
	static int[][] graph;
	
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
		Xy lo;
		for(int i=0;i<graph.length;i++) {			
			for(int j=0;j<graph[i].length;j++) {
				if(graph[j][i] == 1 && visited[j][i] == false) { // 맵을 탐색하다 단지가 있고 방문하지 않았다면
					lo = new Xy(i,j); // 좌표값 저장
					bfs(visited,graph,lo,n); // 해당 좌표부터 너비 우선 탐색을 수행
				}
			}
		}
		System.out.println(count.size()); // 각 단지의 수는 ArrayList의 size
		Collections.sort(count); // 오름차순 출력을 위한 정렬
		for(int i =0; i<count.size();i++) { // 각 단지의 집 수를 출력
			System.out.println(count.get(i));
		}
	
	}


	static int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
	static int[] dy = {0, 1, 0, -1}; 
	static ArrayList<Integer> count = new ArrayList<>();
	
	static void bfs(boolean[][] visited,int[][] graph,Xy a,int n) {
		Queue<Xy> q = new LinkedList<>();
		q.offer(a); //시작 위치를 q에 넣어줌
		visited[a.getY()][a.getX()]=true;
		int cnt=0;
		while(!q.isEmpty()) {
			Xy lo = q.poll();
			cnt++;
			int x= lo.getX();
			int y =lo.getY();
			for(int i=0;i<4;i++) {
				int xx= x + dx[i];
				int yy= y + dy[i];
				if(yy>=n || yy<0 || xx>=n || xx < 0) 
					continue;
				
				if(visited[yy][xx]) 
					continue;
				
				if(graph[yy][xx] == 1){					
					visited[yy][xx]  = true; // 방문처리 후
					q.offer(new Xy(xx,yy)); // 해당 집의 좌표를 큐에 넣어준 뒤 계속해서 탐색
				}
			}
		}
		count.add(cnt);
	}
}
class Xy{
	int x, y;

	public Xy(int x, int y){
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


