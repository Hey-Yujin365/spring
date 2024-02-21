package autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserMybatisDao implements UserDao {

	@Override
	public void insertUser() {
		System.out.println("mybatis 기술을 사용해서 사용자 정보 저장하기");
	}

	@Override
	public void updateUser() {
		System.out.println("mybatis 기술을 사용해서 사용자 정보 수정하기");
	}

	@Override
	public void getUser() {
		System.out.println("mybatis 기술을 사용해서 사용자 정보 조회하기");
	}

}
