/**
 * ���ͽ�Ʈ�� - Ư�� �Ÿ��� ����
 * https://honeywater97.tistory.com/78
 */
package study8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjun18352 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt(); //������ ����(���)
		int m = scan.nextInt(); //������ ����(����)
		int k = scan.nextInt(); //�Ÿ� ����(�ִܰŸ� ��)
		int x = scan.nextInt(); //��� ���� ��ȣ
		
		ArrayList<Integer>[] al = new ArrayList[n+1];
		
		for(int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Integer>(); //�迭�ȿ� ArrayList�� �ٽ� �־��ִ�?
		}
//		System.out.println(Arrays.toString(al)); // [[], [], [], [], []]
		
		for(int i = 0; i < m; i++) {
			al[scan.nextInt()].add(scan.nextInt());
		}
//		System.out.println(Arrays.toString(al)); // [[], [2, 3], [3, 4], [], []]
//		System.out.println(Arrays.toString(al)); // [[], 1�̶� ����� ���� = [2, 3], 2�� ����� ���� = [3, 4], [], []]
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x); //��� ���� ��� (���� x = 1)
		
		int[] visited = new int[n+1];
//		System.out.println(Arrays.toString(visited)); // [0, 0, 0, 0, 0]
		while(!q.isEmpty()) {
			int temp = q.poll(); //temp = 1
			
//			System.out.println(al[1].get(0)); //2
//			System.out.println(al[1].get(1)); //3
			
			for(int i = 0; i < al[temp].size(); i++) {
				if(visited[al[temp].get(i)] == 0) { //���� �湮�� ���� ���� �����
					visited[al[temp].get(i)] = visited[temp] + 1;
					q.add(al[temp].get(i));
				}
			}
		}
//		System.out.println(Arrays.toString(visited)); //[0, 0, 1, 1, 2]
		
		boolean ok = false;
		for(int i = 1; i < visited.length; i++) {
			if(visited[i] == k && i != x) { //(����: �ִܰŸ� k = 2 && ���۳�尡 �ƴ� ���)
				ok = true;
				System.out.println(i);
			}
		}
		if (!ok) {
			System.out.println(-1);
		}
		
	}
		

}
/* Runtime.getRuntime().gc();
long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
System.out.print(usedMemory + " bytes"); */

