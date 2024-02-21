import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.UserService;
import com.sample.vo.User;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		UserService userService = ctx.getBean(UserService.class);
		
		userService.register("hong", "zxcv1234", "홍길동");
		User user = userService.getUser("hong");
		System.out.println(user.getId() + ", " + user.getName());
		
		User other = userService.getUser("kim");
		System.out.println(other.getId() + ", " + other.getName());
	}
}