package method;

public class Test {
	void f(Data data) {
		if(data == null) {
			System.out.println("null 넘기지 마");
			return;
		}
		data.doSomething();
	}
}
