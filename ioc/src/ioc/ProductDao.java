package ioc;

/**
 * 상품정보에 대한 저장, 조회, 변경 작업에 대한 표준을 정의한다.
 * @author realg
 *
 */
public interface ProductDao {

	void insertProduct();
	void getProduct();
	void updateProduct();
	
}
