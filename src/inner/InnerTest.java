package inner;

public class InnerTest {
	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.hiCustomer();
		Customer customer = new Customer();
		customer.getProduct();
		
		Shop2 shop2 = new Shop2();
//		Shop2.Customer2 customer2 = shop2.new Customer2();
		Shop2.Customer2 customer2 = shop2.hiCustomer();
		customer2.getProduct();
		
	}
}
//Alt + Shift + R : 선언부와 사용부 동시에 이름 변경하기
class Shop{
	int product = 10;
	
	void hiCustomer(){
		
	}
}
class Customer extends Shop{
	
	void getProduct() {
		System.out.println("받은 상품의 개수 : "+product);
	}
}

class Shop2{
	
	int product = 10;
	
	Customer2 hiCustomer(){
		return new Customer2();
	}
	
	class Customer2{
		void getProduct() {
			System.out.println("받은 상품의 개수 : "+product);
		}
	}
}









