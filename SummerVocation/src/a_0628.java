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
		
		boolean[][] visited=new boolean[n][n]; //�湮 ���� Ȯ��
		Xy lo;
		for(int i=0;i<graph.length;i++) {			
			for(int j=0;j<graph[i].length;j++) {
				if(graph[j][i] == 1 && visited[j][i] == false) { // ���� Ž���ϴ� ������ �ְ� �湮���� �ʾҴٸ�
					lo = new Xy(i,j); // ��ǥ�� ����
					bfs(visited,graph,lo,n); // �ش� ��ǥ���� �ʺ� �켱 Ž���� ����
				}
			}
		}
		System.out.println(count.size()); // �� ������ ���� ArrayList�� size
		Collections.sort(count); // �������� ����� ���� ����
		for(int i =0; i<count.size();i++) { // �� ������ �� ���� ���
			System.out.println(count.get(i));
		}
	
	}


	static int[] dx = {1, 0 , -1, 0};       // �����¿� ����� x��ǥ
	static int[] dy = {0, 1, 0, -1}; 
	static ArrayList<Integer> count = new ArrayList<>();
	
	static void bfs(boolean[][] visited,int[][] graph,Xy a,int n) {
		Queue<Xy> q = new LinkedList<>();
		q.offer(a); //���� ��ġ�� q�� �־���
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
					visited[yy][xx]  = true; // �湮ó�� ��
					q.offer(new Xy(xx,yy)); // �ش� ���� ��ǥ�� ť�� �־��� �� ����ؼ� Ž��
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


