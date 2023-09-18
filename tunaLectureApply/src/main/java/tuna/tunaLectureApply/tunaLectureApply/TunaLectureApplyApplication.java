package tuna.tunaLectureApply.tunaLectureApply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TunaLectureApplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TunaLectureApplyApplication.class, args);
	}

	// 스케줄러 테스트
//	@Bean
//	public JobDetail userTest() {
//		return JobBuilder.newJob(TestJob.class).withIdentity("TestJob").usingJobData("UserNo", "Test-001").storeDurably().build();
//	}
//
//	@Bean
//	public Trigger userTestTrigger() {
//		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
//
//		return TriggerBuilder.newTrigger().forJob(userTest()).withIdentity("TestJob").withSchedule(scheduleBuilder).build();
//	}

}
