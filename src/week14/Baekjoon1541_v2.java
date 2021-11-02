/**
 * 백준 - 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 * https://blue-boy.tistory.com/184
 */
package week14;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon1541_v2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] arr = scan.nextLine().split("\\-"); // -기준으로 쪼개. - +는 정규표현식에 사용되는 문자. 문자 그 자체를 의미하는 \\
        
        int result = add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            result -= add(arr[i]); // add메소드에서 더해온 숫자들을 빼준다
        }
        System.out.println(result);
    }
    
    public static int add(String i) {
        String[] arr = i.split("\\+"); // -로 쪼갠걸 +로 다시 쪼갬
        
        int result = 0;
        for(String k : arr) {
            result += Integer.parseInt(k); // +로 쪼개진 숫자들을 더함
        }
        return result;
    }

}
