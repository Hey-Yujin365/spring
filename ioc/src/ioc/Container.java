package ioc;

/**
 * 애플리케이션 실행에 필요한 객체를 생성한다.
 * 객체들간의 의존관계에 맞게 객체를 조립한다.
 * @author realg
 *
 */
public class Container {

	public ProductService getProductService() {
		// 애플리케이션 실행에 필요한 객체 생성하기
		ProductJdbcDao productJdbcDao = new ProductJdbcDao();
		ProductMybatisDao productMybatisDao = new ProductMybatisDao();
		
		ProductService productService = new ProductService();
		
		// 객체들간의 의존관계에 맞게 객체 조립하기(의존성 주입이 일어났다.)
		productService.setDao(productMybatisDao);
		
		// 생성, 조립된 객체 제공하기
		return productService;
	}
}
