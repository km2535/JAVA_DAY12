package method;

public class Main {
	public static void main(String[] args) {
		Test t = new Test();
		Data data = new Data() {
			@Override
			void doSomething() {
				System.out.println("두썸띵");
			}
		};
//		data를 사용하려면 Data 클래스의 객체화가 필요하다. 위와 같이 만들면 Data를 익명클래스로 재정의
//		유도한다.
		t.f(data);
		t.f(null);
		
		//객체를 바로 생성하며 메소드의 매개변수로 넘길 수 있다.
		//Data 타입은 추상클래스이기 때문에 바로 생성하면서
		//뒤에 익명클래스를 열어 오버라이딩까지 진행해 주면서 넘겨준다.
		t.f(new Data() {
			@Override
			void doSomething() {
				System.out.println("객체를 생성하며 매개변수로 넘기기");
			}
		});
	}
}
class A{
	
}