package org.kosta.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*
 	Cross Cutting Concern(시스템의 여러 메소드의 실행 소요 시간을 체크)을 정의한 클래스
 */
@Aspect // AOP 담당 객체임을 알리는 어노테이션
@Component // bean 생성을 위한 어노테이션
public class PerformanceReportService {
	
	private Logger log = LogManager.getLogger(getClass());
	
	@Around("within(org.kosta.model..*)")
	public Object timeLogging(ProceedingJoinPoint point) throws Throwable {
		StopWatch watch = new StopWatch();
		watch.start();
		Object retValue = null;
		
		try {
			retValue = point.proceed(); // 실제 Core를 실행
		} finally {
			watch.stop();
			long time = watch.getTotalTimeMillis();
			
			if(time >= 500 && time < 1000) {
				String className = point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				log.warn(className + " " + methodName + " " + time);
			} else if(time >= 1000) {
				String className = point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				log.error(className + " " + methodName + " " + time);
			}
		}
		
		return retValue;
	}
}
