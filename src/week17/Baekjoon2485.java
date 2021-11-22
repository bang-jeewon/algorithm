/**
 * 가로수 - 최대공약수(유클리드 호제법)
 */
package study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		int[] diffs = new int[n-1];
		for(int i = 0; i < n - 1; i++) {
			diffs[i] = array[i + 1] - array[i];
		}
		
		int diff = diffs[0];
		for(int i = 1; i < diffs.length; i++) {
			diff = gcd(diff, diffs[i]);
		}
		
		int trees = (array[n-1] - array[0]) / diff + 1;
		int answer = trees - n;
		
		System.out.println(answer);
	}
	
	static int gcd(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		while(min != 0) {
			int temp = max % min;
			max = min;
			min = temp;
		}
		return max;
	}

}
