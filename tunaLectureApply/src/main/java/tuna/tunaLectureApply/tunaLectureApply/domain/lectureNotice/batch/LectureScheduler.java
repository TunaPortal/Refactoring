package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class LectureScheduler {
    private final JobLauncher jobLauncher; // 배치 Job 실행시키는 역할. jobLauncher.run(job, jobParameter)
    private final Job job;
    private final BatchConfig batchConfig;

    @Scheduled(cron = "0/5 * * * * ?")
    public void runJob() {
        try {
            jobLauncher.run(
                    job, new JobParametersBuilder().addString("dateTime", LocalDateTime.now().toString()).toJobParameters()
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
