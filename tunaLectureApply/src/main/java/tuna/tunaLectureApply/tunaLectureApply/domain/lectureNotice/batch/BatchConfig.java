package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository.LectureNoticeRepository;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;

@Configuration // Batch의 모든 Job은 Configuration으로 등록
@RequiredArgsConstructor // 생성자 DI를 위한 lombok
public class BatchConfig {

    private final LectureNoticeRepository lectureNoticeRepository;
    private final LectureNoticeService lectureNoticeService;

    // Batch 프로세스 : Job -> Step -> Tasklet

    @Bean
    public Job updateTunaJob (JobRepository jobRepository, Step updateTunaStep) {
        // Job : 배치 처리 과정을 하나의 단위로 만든 객체, 1개 이상의 Step을 가짐
        // JobRepository -> batch에서 사용되는 도메인 객체들의 CRUD 작업에 이용됨 (@EnableBatchProcessing 어노테이션 사용 시 자동제공 but Batch 5에서는 내장)

        // start() - Flow 시작하는 Step 설정
        // on() - Step의 실행 결과로 돌려받는 ExitStatus를 캐치하여 매칭하는 패턴, TansitionBuilder을 반환
        //          *: 0개 이상의 문자와 매칭, 모든 ExitStatus와 매칭
        //          ?: 정확히 1개의 문자와 매칭
        // next() - 다음 Step
        // end() - build()앞에 위치하면 FlowBuilder를 종료하고 SimpleFlow 객체를 생성
        //          SimpleFlow : 배치에서 제공하는 Flow 구현체. Step, Flow, JobExecutionDecider들을 담고 있는 State를 실행시키는 도메인 객체
        //                      (ex. updateTunaJob를 실행시킴)
        return new JobBuilder("updateTunaJob", jobRepository)
                .start(updateTunaStep)
                .on("FAILED")
                .stopAndRestart(updateTunaStep)
                .on("*")
                .end()
                .end()
                .build();
    }

    @Bean
    public Step updateTunaStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        // Step : 실제 배치 작업을 정의 및 제어하고, 순차적 단계를 캡슐화 (수행순서 지정)
        // Step에서 tasklet() 또는 chunk() 사용
        return new StepBuilder("updateTunaStep", jobRepository)
                .tasklet(new LectureTasklet(lectureNoticeRepository, lectureNoticeService), transactionManager)
                .build();
    }
}
