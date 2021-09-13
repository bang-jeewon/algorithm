/**
 * �̺�Ž�� - ����ī��2
 */
package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10816 {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		//���ĵ� �־�� �̺�Ž���� �����ϴ�(�������� ����)
		Arrays.sort(arr);
		
		int m = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			//key(ã���� �ϴ� ��)
			int key = in.nextInt();
			//�ߺ��� ������ �迭 ���� = (��� - �ϰ�)
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}

	//�ϰ�
	//high�� ��� ������ ����ش�
	public static int lowerBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length; //������ ������ max��
		
		while(low < high) {
			int mid = (low + high)/2;
			
			//���� key���� �迭�� �߾Ӱ�(arr[mid])���� �۰ų� ���� ���, mid�� high�� �����Ѵ�
			if(key <= arr[mid]){
				high = mid;
			//���� ���� key���� �߾Ӱ����� Ŭ ���, low�� �߾Ӱ� ���������� �����Ѵ�
			}else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	//���
	//low�� ��� �ڷ� �̷��ش�
	public static int upperBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high)/2;
			
			//���� key���� �迭�� �߾Ӱ�(arr[mid])���� ���� ���, ���� mid���� high������ �ٲ��ش�
			if(key < arr[mid]) {
				high = mid;
			//���� ���� key���� �߾Ӱ����� ũ�ų� ���� ���, low�� �߾Ӱ��� ���������� �����Ѵ�
			}else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	
}
