package exception;

public class ExcpetionTest {
	public static void main(String[] args) {
		try {
			System.out.println(Integer.parseInt("10"));
//			System.out.println(Integer.parseInt("Hello"));
			System.out.println(Integer.parseInt("30"));
		}
		catch(NumberFormatException nfe) {
			System.out.println("숫자로 이루어진 문자열만 바꿀 수 있습니다.");
		}
		finally {
			System.out.println("꼭 해야되는 문장");
		}
	}
}
