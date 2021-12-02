package org.kosta.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 스프링 부트 설정 클래스
 * context component scan -> IOC DI DL
 * 현재 @SpringBootApplication이 명시된 클래스의 패키지 또는 패키지 이하의 클래스들만 bean 생성되고
 * DI된다
 */
@SpringBootApplication
public class SpringBootStudy1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudy1Application.class, args);
	}

}
