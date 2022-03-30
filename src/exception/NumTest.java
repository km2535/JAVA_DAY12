package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumTest {
	public static void main(String[] args) {
		//Alt + Shift + Z > ↓ > Enter : try ~ catch 블럭 만들기
		try {
			Integer.parseInt("Hello");
		} catch (NumberFormatException e1) {
			
		}
		//두 정수 입력받아서 앞의 수를 뒤의 수로 나눈 몫 출력하기
		//입력
		//	정수 두개 입력받기
		Scanner sc = new Scanner(System.in);
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.print("첫번째 정수 : ");
				int num1 = sc.nextInt();
				System.out.print("두번째 정수 : ");
				int num2 = sc.nextInt();
				
				//처리
				//	위에서 입력받은 두 수 가져와서
				//	앞의 수를 뒤의 수로 나누기
				int result = num1/num2;
				//출력
				//	위에서 처리된 결과값 출력하기
				System.out.println("결과 : "+result);
			}
			catch(ArithmeticException ae) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
			catch(InputMismatchException ime) {
				System.out.println("숫자만 입력하세요 제발");
			}
			catch(Exception e) {
				System.out.println("알 수 없는 오류 발생 / 개발자에게 알려주세요~");
	//			System.out.println(e);
			}
		}
	}
}







