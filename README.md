"# JAVA_DAY12"

# JAVA 12

## 내부 클래스

- 클래스 내부에 클래스를 선언하여 외부 클래스의 필드에 쉽게 접근하기 위해서 사용한다. 내부 클래스의 필드를 사용하기 위해서는 외부 클래스 객체에서 내부 클래스를 객체화 해야한다.

```
외부클래스명 객체명 = new 외부클래스명();
import를 사용하지 않는 경우 아래와 같이 명확하게 명시한다.
외부클래스명.내부클래스명 객체명 = 외부클래스명.new 내부클래스생성자();
```

### 내부 클래스를 사용하는 이유

- 상속처럼 사용
  - 외부 클래스의 필드를 마치 내것처럼 접근하여 사용하기 위함
- 캡슐화(Encapsulation)
  - 캡슐화란 정보의 은닉의 목적이 있다. (접근제어권한자 private도 일종의 캡슐화임)
  - 외부 클래스의 객체가 없다면 내부 클래스도 존재할 수 없기 때문에 다른 클래스에서는 내부에 수비게 접근하지 못하도록 숨기기 위함.

```java
package inner;

//import inner.Shop2.Customer2;

public class InnerTest {
	public static void main(String[] args) {
//		Shop클래스는 아래처럼 객체화 할  수있다.
		Shop shop = new Shop();
//		당근 클래스 내부의 메소등 접근이 가능하다.
		shop.hiCustomer();
//		우리가 숨기고 싶은 클래스도 아래처럼 쉽게 객체화 가능하다.
		Customer customer = new Customer();
//		당근 객체의 클래스 메소드에 접근하기 쉬워진다.
		customer.getProduct();


//		우리는 특정 클래스가 객체화 될 때 다른 클래스를 객체화 시키고 싶다.
		Shop2 shop2 = new Shop2();
		shop2.hiCustomer();
//		내부 클래스는 아래와 같이 바로 객체화 할 수 없다.
//		Customer2 customer2 = new Customer2();
//		위처럼 외부클래스를 먼저 객체화 하고 아래와 같이 해야 내부 클래스를 객체화 시킬 수 있다.
//		import를 쓰지않으려면 아래와 같이 위치를 명시해주어야 한다.
//		Shop2.Customer2 customer2 = shop2.new Customer2();
//		customer2.getProduct();

//		메소드에 직접 미리 객체화를 선언해주어 메소드가 실행 시 객체화가 이루어지도록 한다.
		Shop2.Customer2 customer2 = shop2.hiCustomer();
		customer2.getProduct();
//		아래는 짧아지기는 한데 비추, 쓸때마다 객체화 해야 함ㅋㅋ
//		shop2.hiCustomer().getProduct();

	}
}
// Alt + shift + R	:	선언부와 사용부 동시에 이름 변경하기
class Shop {
	int product = 10;

	void hiCustomer() {

	}
}
// Customer가 Shop을 상속 받는게 맞을 까?
// 그렇게 되면 customer는 shop의 변수를 모두 가지게 된다.
// 지금은 없지만 shop의 고유기능 money를 cutomer하고 공유하게 되는 것이다.
class Customer extends Shop{
	void getProduct() {
		System.out.println("받은 상품의 갯수 : " + product);
	}
}
// 필요할때만 customer2가 getProduct하는 것이 맞다.
// 특정 조건을 만들어주고 그 특정조건이 캡슐화이다.
class Shop2{
	int product = 10;

	Customer2 hiCustomer() {
		return new Customer2();
	}

	class Customer2{
		void getProduct() {
			System.out.println("받은 상품의 갯수 : " + product);
		}
	}
}
```

- 내부 클래스를 만드는 이유와 캡슐화하는 이유.
- 내부클래스 정의하는 방법, 캡슐화하는 방법
- 내부 크래스 사용방법, 캡슐화해제 하는 방법

### 익명클래스

- 이름이 없는 클래스
- 단 하나의 객체(익명 구현 객체)만을 위한 클래스

만약 추상 클래스의 추상 메소드를 만들고 클래스 객체를 다른 클래스에서 메소드의 매개변수를 받아 추상메소드를 사용한다면 재정의가 이루어 질까?

```java
추상 클래스, 추상 메소드
package method;

public abstract class Data {
	abstract void doSomething();
}
```

```java

package method;

public class Test {
	void f(Data data) {
		data.doSomething();
	}
}
```

분명 우리는 Test클래스에 추상클래스를 받았으나 추상메소드를 재정의 하지 않는다.
이게 가능한 이유는 설계의 차이가 있다.
물론 Test에서 doSomthing이라는 메소드를 정의한다면 분명 재정의하라고 유도 할 것이다. 그러나 메소드를 통해 사용한다는 것은 이 메소드를 사용하기 전 까지 내부의 데이터는 사용하지 않는다. 즉, 메인 메소드에서 Test클래스를 객체화하고 f메소드를 사용하기 전까지 사용하지 않는다는 것이며 Test클래스 객체화가 이루어지고 f메소드를 사용할때 비로소 doSomthing 메소드에 대해서 정의하라고 할 것이다.

```java
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
//		data를 사용하려면 Data 클래스의 객체화가 필요하다.
//      v위와 같이 만들면 Data를 익명클래스로 재정의 유도한다.
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
```

이전과 달리 추상메소드와 추상클래스를 메인메소드에서 재정의가 이루어진다.
익명클래스로 객체화되는 것을 익명 구현 객체라고 한다.
모습은 마치 업캐스팅이 이루어지는 것 처럼 보이지만 다운캐스팅을 할 수없다.
이는 자식 클래스로써 가지는 클래스명이 없기 때문이다.

```java
package zoo;

public abstract class Animal {
	String name;
	String gender;
	int age;

	abstract void makeSomeNoise();
}
```

위의 추상 클래스를 메인 메소드에서 사용해보자

```java
package zoo;

public class Ground {
	public static void main(String[] args) {
//		익명 클래스는 앞에 있는 생성자의 클래스를 상속 받고 있는 이름 없는 자식 클래스이다.
//		일회용 클래스. 그 앞에 있는 생성자를 통해 만드는 객체 딱 하나만을 위한 클래스이고
//		그 때 만들어지는 객체는 익명 클래스 안에서 구현한 메소드 내용을 가지게 된다.ㅣ
//		이렇게 만들어지는 객체를 '익명 구현 객체'라고 한다.
		Animal dog = new Animal() {
			@Override
			void makeSomeNoise() {
				System.out.println("왈왈");
			}
		};
		Animal cat = new Animal() {
			void makeSomeNoise() {
				System.out.println("야옹");
			};

		};
//		부모 타입으로 자식 객체를 담은 업캐스팅이나 다름 없으나 자식 클래스명이 없기 때문에
//		다운캐스팅을 할 수 없다...
		Animal bird = new Animal() {
//			이름이 없어서 다운캐스팅을 할 수없다.
//			void fly() {
//				System.out.println("오리날다");
//			}

			@Override
			void makeSomeNoise() {
				System.out.println("짹짹");
			}
		};
		dog.makeSomeNoise();
		cat.makeSomeNoise();
		bird.makeSomeNoise();

	}
}
```

객체화 시키면 재정의를 하라고 경고메시지가 나오며 곧바로 익명클래스로 객체화를 유도하여 추상메소드를 재정의하라고 유도하는데 이것이 바로 익명 구현 객체이다.

## 예외 처리

- 에러 : 심각한 오류, 프로그램 종료
- 예외 : 덜 심각한 오류, 경고 메시지

```java
System.out.println(Integer.parseInt("Helle"));
```

위와 같이 메인 메소드에 출력을 하는데 문자열 정수가 아닌 문자열의 문자를 형변환하면 NumberFormatException의 경고 메시지가 콘솔창에 출력된다.
메시지를 보면 NumberFormatException도 클래스이자 객체인 것을 알 수 있다.
이 객체를 이용하여 오류 메시지가 아닌 다른 문장을 출력하도록 유도 할 수 있고
이것을 구현하는 키워드로 아래에서 다루게 될 try ~ catch ~ finally 문이다.

### TRY ~ CATCH ~ FINALLY

아래와 같이 사용한다.

```
	try{
		예외가 발생할 수 있는 문장
		...
	}
	catch(예외클래스명 객체명) {
		예외 발생시 수행할 문장
	}
	finally{
		예외 발생 여부에 상관 없이 무조건 수행할 문장
	}
```

그럼 NumberFormatException 메시지를 catch하여 다른 문장이 나오도록 유도한자.

```java
package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(Integer.parseInt("10"));
			System.out.println(Integer.parseInt("Helle"));
		}catch (NumberFormatException nfe) {
			System.out.println("숫자로 이루어진 문자열만 바꿀 수 있습니다.");
		}finally {
			System.out.println("꼭 해야 되는문장");
		}
	}
}
```

위를 실행하면 콘솔 창에는 더이상 경고메시지가 아닌 개발자가 정한 메시지를 출력할 수 있게된다.
이제 2개의 정수를 받아서 사용자가 낼 수 있는 예외들을 원하는 문장으로 출력하게 만들어 보자

```java
package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumTest {
	public static void main(String[] args) {
//		 두 수 입력 받아서 앞의 수를 뒤의 수로 나눈 몫 출력하기
//		입력
//		정수 2개 입력받기
		Scanner sc = new Scanner(System.in);
		while(true) {
			sc = new Scanner(System.in);
//			alt + shift + z > trycatch 블럭 만들기
			try {
				System.out.println("첫번 째 정수 : ");
				int num1 = sc.nextInt();
				System.out.println("두번 째 정수 : ");
				int num2 = sc.nextInt();
//		처리
//		두수를 가져와서 앞의 수를 뒤의 수로 나누기
				int result = num1 / num2;
//		출력
//		윟에서 처리된 결과값 출력하기
				System.out.println("결과 : " + result);
			}catch(ArithmeticException ae){
				System.out.println("0으로 나눌 수 없다.");
			}catch(InputMismatchException ime) {
				System.out.println("숫자만 입력해라");
			}catch(Exception e) {
            // 어떤 예외인지 모를 경우
				System.out.println("너 실수 했다.");
                // 예외의 출력문을 출력해서 개발자가 예외를 만들 수 있도록 하였다.
				System.out.println(e);
			}
		}
	}
}

```
