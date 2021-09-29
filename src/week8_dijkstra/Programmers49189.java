/**
 * ���ͽ�Ʈ�� - ���� �� ���
 * https://moonsbeen.tistory.com/m/31?category=1184369
 */
package study8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers49189 {

	public static void main(String[] args) {
		int n = 6; //���
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}; //���� ����
//		System.out.println(edge.length); //7
		
		System.out.println(solution(n, edge));
	}
	
	public static int solution(int n, int[][] edge) {
        boolean[][] node = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        
        //2���� ���� ���
        for(int i = 0; i < edge.length; i++) {
        	int x = edge[i][0]; //3
        	int y = edge[i][1]; //6
        	node[x][y] = true;
        	node[y][x] = true;
        }
//        System.out.println(Arrays.deepToString(node));
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1); //1�� ��带 ť�� ����
        visited[1] = true; //1�� ��� �湮ó����, 0���� ��� ����
        int qSize = 0;
//        System.out.println(q.size()); //1
        
        while(!q.isEmpty()) {
        	qSize = q.size(); //1
        	for(int i = 0; i < qSize; i++) {
        		int temp = q.poll(); //ť���� ���� ��� = 1
        		for(int j = 1; j <= n; j++) { //j=2 �϶� 2�� ��带 ť�� ����, q.add(2);
        			if(visited[j] == false && node[temp][j] == true) {
        				visited[j] = true;
        				q.add(j);
        			}
        		}
        	}
        }
        
        return qSize;
    }

}
