package dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// 스프링 컨테이너 객체 생생하기
		// ClassPathXmlApplicationContext 객체는 context-dependency.xml 설정 파일을 읽어서 객체를 생성하고 조립한다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context-dependency.xml");
		
		// 스프링 컨테이너가 생성하는 객체 가져오기
		Cloud cloud11 = ctx.getBean("cloud1", Cloud.class);
		Cloud cloud12 = ctx.getBean("cloud1", Cloud.class);
		Cloud cloud13 = ctx.getBean("cloud1", Cloud.class);
		Cloud cloud14 = ctx.getBean("cloud1", Cloud.class);
		Cloud cloud15 = ctx.getBean("cloud1", Cloud.class);
		
		System.out.println(cloud11);
		System.out.println(cloud12);
		System.out.println(cloud13);
		System.out.println(cloud14);
		System.out.println(cloud15);
		
		cloud11.connect();
		
	}
}
