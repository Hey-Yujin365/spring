package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// ClassPathXmlApplicationContext가 스프링 컨테이너다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		// 스프링 컨테이너 ctx에 getBean으로 context.xml에서 만든 객체 꺼내오기
		// getBean에게 객체.class로 설계도 정보 전달해서 객체 가져오기
		ProductService productService = ctx.getBean(ProductService.class);
		
		productService.신규상품등록();
		productService.상품상세정보조회();
		productService.상품정보수정();
	}
}
