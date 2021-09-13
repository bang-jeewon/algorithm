/**
 * BFS - ���̷���
 */
package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2606 {
	
	static int arr[][];       //�׷��� �迭
	static boolean visited[];  //�湮 Ȯ���ϴ� �迭
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt(); //��ǻ���� ��
		int line = scan.nextInt(); //��Ʈ��ũ �� ����� �ִ� ��ǻ�� ���� ��. �� ������ ��
		
		arr = new int[node+1][node+1];   //�� ��ǻ�Ͱ� ���� ���θ� ������ �迭. ���?
		visited = new boolean[node+1]; //��ǻ���� Ž�� ���� Ȯ��
		
		for(int i = 1; i <= line; i++) { //�׷��� ����. �������??
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a][b] = 1; //��ǻ�� ��帶�� ����
			arr[b][a] = 1; //��ǻ�� ��帶�� ����
		}
		System.out.println(bfs(1)); //1�� ��ǻ�Ϳ� ����� ��~~~�� ��ǻ��(���)�� ������ ã���� �ȴ�
		scan.close();
	}
	
	static int bfs(int start) { // BFS�޼ҵ�
		
		Queue<Integer> que = new LinkedList<>();
		
		visited[start] = true;
		
		que.offer(start);
		
		int cnt = 0; //������ ��ǻ���� ��
		while(!que.isEmpty()) {
			int x = que.poll(); //ť���� ù��° ���� ��ȯ�ϰ� ����. ��ȯ�� 1�� ���� x�� �����
			
			for(int i = 1; i < arr.length; i++) { //���ʴ�� 1���� ����� ��ǻ�͵��� ã�� cnt���� ����
				//if(node[1][2] == 1 && check[2] !=1) => (1,2)����� ��ǻ�� ���̷���~~~~~ => if ���ǹ� ����
				//if(node[1][1] == 1 && check[1] !=1) => node[1][1]�� 1�� �ƴϹǷ� �ش����. i����
				//��尡 ������ְ�, �湮�� �����
				if(arr[x][i] == 1 && visited[i] !=true ) {
					que.offer(i); //que.offer(2); => ť�� 2�� �־���
					visited[i] = true; //�湮�ߴٰ� true
					cnt++; //����� ���̷��� �ɸ��� ��ǻ���� ��
				}
			}
		}
		return cnt;
	}

}
