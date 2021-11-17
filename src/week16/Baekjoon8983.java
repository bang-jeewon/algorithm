/**
 * ��ɲ� - �̺�Ž��(�̺�Ž���� �̿��ؾ� �ϴ� ����: ���� �������� �Ÿ��� ���� ª������ �ش� ���� ����� �����ϱ� ����??
 * https://www.acmicpc.net/problem/8983
 */
package study16;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon8983 {
	
	static int[] gun;
	static int M, N, L;
	static int cnt;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        M = scan.nextInt(); // ����� ��
        N = scan.nextInt(); // ������ ��
        L = scan.nextInt(); // �����Ÿ�
        
        gun = new int[M];
        for(int i = 0; i < M; i++) {
        	gun[i] = scan.nextInt();
        }
        Arrays.sort(gun); // ����
        
        for(int i = 0; i < N; i++) {
        	int x = scan.nextInt();
        	int y = scan.nextInt();
        	
        	int position = binarySearch(x, y, 0, M - 1); // �̺�Ž���� ��ġ�� ����� ��ġ���� �޾ƿ´�
        	int dist = Math.abs(gun[position] - x) + y;  // ���� �������� �Ÿ�
        	
        	if(dist <= L) {
        		cnt++;
        	}
        }
        System.out.println(cnt);
        
//        for(int i = 0; i < N; i++) {
//        	int y = animal[i][1];
//        	int x = animal[i][0];
//        	
//        	for(int j = 0; j < M; j++) {
//        		int d = Math.abs(gun[j] - x) + y;
//        		
//        		if(d <= L) {
//        			cnt++;
//        		}
////        		if( y - x <= (L - gun[j]) && y + x <= (L + gun[j]) ) {
////        			cnt++;
////        		}
//        	}
//        }
        scan.close();
	}
	
	public static int binarySearch(int x, int y, int left, int right) {
		
		int pl = left;
		int pr = right;
		
		do {

			int pc = (pl + pr) / 2;

			int dist = Math.abs(gun[pc] - x) + y;

			if (dist <= L || gun[pc] == x)
				return pc;

			if (gun[pc] < x)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		if (pl > right)
			return pr;

		if (pr < left)
			return pl;

		return (Math.abs(gun[pl] - x) < Math.abs(gun[pr] - x) ? pl : pr);
		
//        while(pl <= pr) {
//        	
//        	if(pl > right) {
//        		return pr;
//        	}
//        	if(pr < left) {
//        		return pl;
//        	}
//        	
//        	int mid = (pl + pr) / 2;
//        	int dist = Math.abs(gun[mid] - x) + y;
//        	
//        	if(dist <= L || gun[mid] == x) {  //���� ������ x��ǥ�� ������ return
//        		return mid;
//        	}
//        	
//        	if(gun[pr] < x) {  //��밡 �������� ���ʿ� ���� ���
//        		pl = mid + 1;
//        	}else {               //��밡 �������� �����ʿ� ���� ���
//        		pr = mid - 1;
//        	}
//        }
//        return (Math.abs(gun[pl] - x) < Math.abs(gun[pr] - x) ? pl : pr);
        
	}

}
