package ioc;

public class App {

	public static void main(String[] args) {
		
		Container container = new Container();
		ProductService service = container.getProductService();
		
		service.신규상품등록();
		service.상품상세정보조회();
		service.상품정보수정();
	}
}
