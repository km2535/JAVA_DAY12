package zoo;

public class Ground {
	public static void main(String[] args) {
		//익명 클래스는 앞에 있는 생성자의 클래스를 상속 받고 있는
		//이름 없는 자식 클래스이다. 일회용 클래스이다.
		//그 앞에 있는 생성자를 통해 만드는 객체 딱 하나만을 위한 클래스이고
		//그 때 만들어지는 객체는 익명 클래스 안에서 구현한 메소드 내용을 가지게 된다.
		//이렇게 만들어지는 객체를 "익명 구현 객체" 라고 한다.
		Animal dog = new Animal() {
			@Override
			void makeSomeNoise() {
				System.out.println("왈왈");
			}
		};
		Animal cat = new Animal() {
			@Override
			void makeSomeNoise() {
				System.out.println("냐옹");
			}
		};
		Animal bird = new Animal() {
			
			//새로운 메소드를 구현하게 되면 자식에서 내용을 추가하는 것이나 마찬가지이고
			//만들어지는 객체를 이 익명클래스 타입으로 다운캐스팅을 해야만 사용 가능하다.
			//하지만 익명클래스는 일회용으로 이름이 없기 때문에 다운캐스팅이 불가능하다.
			//따라서 새로운 메소드는 이 영역 내부에서만 사용 가능하다.
			void fly() {
				System.out.println("오리날다");
			}
			
			@Override
			void makeSomeNoise() {
				System.out.println("짹짹");
			}
		};
		
		dog.makeSomeNoise();
		cat.makeSomeNoise();
	}
}








