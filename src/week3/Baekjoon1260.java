/**
 * DFS, BFS - DFS�� BFS
 */
package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1260 {
	
	public static int[][] arr; //2���� �迭. �������.
	public static boolean[] visited; //��� �湮 ���� visited
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt();  //node��
		int line = scan.nextInt();  //���� ��
		int start = scan.nextInt(); //������ node
		
		arr = new int[node+1][node+1];
		visited = new boolean[node+1];
		
		for(int i = 1; i <= line; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			//������� : ���� ������ ���赵�� ������ �迭�� ǥ���� ��. �ð����⵵�� ���� �� �ִٴ� ������ ����.
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		//visited�� �� ���⼭ �����ϴ°���?? �� �ι��� �����ϴ°���??
		visited = new boolean[node+1];
		dfs(start);
		System.out.println();
		
		visited = new boolean[node+1];
		bfs(start);
		
		scan.close();
	}
	
	private static void dfs(int start) {
		visited[start] = true; //ó�� �����ϴ� ���� �湮�ѰŴϱ�, true�� �ʱ�ȭ����
		System.out.print(start + " ");
		
		if(start == arr.length) {
			return;
		}
		
		for(int i = 1; i < arr.length; i++) {
			//start���� ������ �� ����Ǿ��ְ� && �湮���� ���� ����� ���, 
			if(arr[start][i] == 1 && visited[i] == false) {
				//�� ����ȣ(i)�� dfs�� �ٽ� �־��༭ ������� ������ i���� ����Ǿ� �ִ� ��带 �ٽ� Ž���Ͽ� sysout(i + " ")���� ��µ� �� �ֵ��� ���� => ���ȣ��
				dfs(i);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		
		visited[start] = true; //ó�� �����ϴ� ���� �湮�ѰŴϱ�, true�� �ʱ�ȭ����
		System.out.print(start + " ");
		
		while(!que.isEmpty()) {
//			int temp = que.peek();
			int temp = que.poll();
			for(int i = 1; i < arr.length; i++) {
				if(arr[start][i] == 1 && visited[i] == false) {  //���⸦ Ȯ�� ��������!!
					que.add(i);
					visited[i] = true; //�湮�ߴٰ� �������
					System.out.print(i + " "); //i��尪 ��µ� �� �ֵ��� ����
				}
			}
		}
	}

}
