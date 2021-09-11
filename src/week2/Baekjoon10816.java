/**
 * 이분탐색 - 숫자카드2
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
		
		//정렬돼 있어야 이분탐색이 가능하다(오름차순 정렬)
		Arrays.sort(arr);
		
		int m = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			//key(찾고자 하는 값)
			int key = in.nextInt();
			//중복된 원소의 배열 길이 = (상계 - 하계)
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}

	//하계
	//high를 계속 앞으로 당겨준다
	public static int lowerBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length; //구간의 길이의 max값
		
		while(low < high) {
			int mid = (low + high)/2;
			
			//비교할 key값이 배열의 중앙값(arr[mid])보다 작거나 같을 경우, mid를 high로 설정한다
			if(key <= arr[mid]){
				high = mid;
			//만약 비교할 key값이 중앙값보다 클 경우, low를 중앙값 다음값으로 설정한다
			}else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	//상계
	//low를 계속 뒤로 미뤄준다
	public static int upperBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high)/2;
			
			//비교할 key값이 배열의 중앙값(arr[mid])보다 작을 경우, 현재 mid값을 high값으로 바꿔준다
			if(key < arr[mid]) {
				high = mid;
			//만약 비교할 key값이 중앙값보다 크거나 같을 경우, low를 중앙값의 다음값으로 설정한다
			}else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	
}
