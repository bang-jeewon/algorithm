/**
 * 진법변환 - 비밀지도
 */
package week4;

public class Programmers17681 {
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[] {9, 20, 28, 18, 11};
		int[] arr2 = new int[] {30, 1, 21, 17, 28};
		
		String[] answer = solution(5, arr1, arr2);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i = 0; i < n; i++) {
//			int l = Integer.parseInt(Integer.toBinaryString(arr1[i] | arr2[i]));
//			String str = String.format("%0" + n + "d", l);
			
			String str = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i] | arr2[i])));
			
			str = str.replace("1", "#");
			str = str.replace("0", " ");
			
			answer[i] = str;
		}
		return answer;
	}

}
