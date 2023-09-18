package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository.LectureNoticeRepository;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;

import java.util.List;

@RequiredArgsConstructor
public class LectureTasklet implements Tasklet {
    // Tasklet : Step에서 수행될 기능들을 명시
    // Tasklet은 외부 클래스를 만들어서 Tasklet을 implements 받아 구현을 해야하고, 그에 따라 execute 메서드를 구현해야 함
    // => 인자 :
    //     1. contribution - 현재 단계 실행을 업데이트하기 위해 다시 전달되는 변경 가능한 상태
    //     2. chunkContext - 호출 간에는 공유되지만 재시작 간에는 공유되지 않는 속성

    // Tasklet은 단순하게 처리할 수 있으나 대용량의 경우 부하 감당하기 어려움
    // 대용량일 경우에는 데이터를 Chunk로 쪼개서 사용 (ItemReader / ItemProcessor / ItemWriter)

    private final LectureNoticeRepository lectureNoticeRepository;
    private final LectureNoticeService lectureNoticeService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("=====튜나 데이터 Update=====");
        List<LectureNotice> findAllWithSubject = lectureNoticeRepository.findAllWithSubject();

        if(findAllWithSubject.isEmpty() || findAllWithSubject == null || findAllWithSubject.size() == 0) {
            System.out.println("====찾은 과목이 없습니다====");
        } else {
            for (LectureNotice lectureNotice : findAllWithSubject) {
                System.out.println("====찾은 과목이 있습니다====");
            }
        }

        System.out.println("=====끝=====");
        return RepeatStatus.FINISHED;
    }
}
