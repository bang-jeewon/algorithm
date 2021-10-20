/**
 * �� - ���߿켱����ť
 */
package study10;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42628 {

	public static void main(String[] args) {
//		String[] operations = {"I 16","D 1"};
		String[] operations = { "I 7", "I 5", "I -5", "D -1" };

		System.out.println(solution(operations));
	}

	public static int[] solution(String[] operations) {

		int[] answer = { 0, 0 };

		PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder()); // �ִ��� (�ִ밪 �켱���� ����)
		PriorityQueue<Integer> minq = new PriorityQueue<>(); // �ּ��� (�ּڰ� �켱���� ����)

		String[] temp = {};
		for (int i = 0; i < operations.length; i++) {

			temp = operations[i].split(" ");
//			System.out.println(Arrays.toString(temp)); //[I, 7]  [I, 5] [I, -5] [D, -1]

			if (temp[0].equals("I")) {
				maxq.add(Integer.parseInt(temp[1]));
				minq.add(Integer.parseInt(temp[1]));

//				System.out.println(maxq); // [7, 5, -5]
//				System.out.println(minq); // [-5, 7, 5]
			} else if (temp[0].equals("D")) {

				if (!maxq.isEmpty()) {
					if (temp[1].equals("1")) { // ������ ���ڰ� 1 �� ���
						int max = maxq.peek();
						maxq.remove(max);
						minq.remove(max);
					} else { // ������ ���ڰ� - 1 �� ���
						int min = minq.peek();
						maxq.remove(min);
						minq.remove(min);
					}
//					System.out.println(maxq); // [7, 5]
//					System.out.println(minq); // [5, 7]
				}
			}

		}
		if (!maxq.isEmpty()) {
			answer[0] = maxq.peek();
			answer[1] = minq.peek();
		}

		return answer;
	}

}
