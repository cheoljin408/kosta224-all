package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Tool;

/**
 * 기존의 제어방식
 * 사용자가 망치(컴포넌트)를 사용하기 위해서는 Hammer 객체를 생성하고 work를 호출
 * 만약 도구를 삽으로 변경해야 한다면 객체 생성부를 수정해서
 * new Spade()를 명시해야 한다(추상화 또는 계층구조화 또는 갭슐화가 되어있지 않다면 
 * 메소드 호출부 또한 변경해야 한다)
 * 
 * 이럴 경우 도구(or 컴포넌트)가 변경될 때마다 해당 코드 부분의 수정은 불가피하다
 * --> 사용자 측과 도구(컴포넌트) 측과의 결합도가 높은 상태(낮은 유지보수성)
 * 
 * 계층구조화를 시켜서 메소드 또는 소통 방식의 표준화를 시킨다
 * Interface: Tool
 * abstract method: work()
 * 
 * 현 구조에서는 컴포넌트를 변경할 때 코드 수정은 불가피하다
 * 
 * ---------------------------------------------------
 * 
 * IOC 방식을 적용
 * IOC (Inversion Of Control) Container -> ClassPathXmlApplicationContext를 이용해
 * 스프링 설정 파일 (ioc.xml)을 시스템 시작시에 로딩해서 필요한 객체를 생성해서 저장해놓고
 * 어플리케이션에서 필요시 해당 객체(bean)를 요청하면 IOC 컨테이너가 해당 객체를 반환해준다
 * 
 * 기존 제어방식과 IOC 제어방식을 비교
 * 
 * 기존 제어방식: 컴포넌트를 사용하는 착과 제공하는 측의 결합도가 높다
 * 			  컴포넌트가 변경되면 사용하는 착의 프로그램도 함께 변경되어야 한다
 * 
 * IOC (DI, DL) 제어방식: 컴포넌트를 사용하는 측과 제공하는 측의 결합도가 낮다 (느슨한 결합도)
 * 						컴포넌트가 변경될 시에 사용하는 측의 프로그램의 변경은 없다
 * 						컴포넌트 변경 또는 업데이트 시에는 스프링 ioc 설정(xml과 annotation)만 변경하면 된다
 */
public class TestUser2_IOC {
	public static void main(String[] args) {
		// 기존 방식 - 컴포넌트 변경시 코드 수정
		// Tool tool = new Hammer();
		// Tool tool = new Spade();
		// tool.work();
		
		// IOC 방식 적용
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
		
		Tool tool = (Tool) factory.getBean("tool");
		System.out.println(tool);
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));
		System.out.println(factory.getBean("tool"));
		// 동일한 객체의 주소값이 연속으로 출력
		// spring ioc container는 singleton 방식으로 객체를 운용한다
		tool.work();
		
		factory.close();
	}
}
