import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a_0720_new {

	static int n, m;
	static int[] parent;
	static int count;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		String[] word = new String[n];
		int root = 0;
		word=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			parent[i]=Integer.parseInt(word[i]);
			if(parent[i]==-1) {
				root=i;
			}
		}
			
		int  m = Integer.parseInt(br.readLine());

		deleteNode(m);

		count = 0;
		visited = new boolean[n];
		countLeaf(root);

	
		System.out.println(count);

	}
	public static void deleteNode(int d) {
		parent[d] = -2; //삭제된 노드 -2로 표시
		for(int i = 0; i < n; i++) {
			if(parent[i] == d) {
				deleteNode(i);
			}
		}
	}
	public static void countLeaf(int s) {
		boolean isLeaf = true;
		visited[s] = true;
		if(parent[s] != -2) {
			for(int i = 0; i < n; i++) {
				if(parent[i] == s && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if(isLeaf) {
				count++;
			}
		}
	}
}