package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureNoticeRepository extends JpaRepository<LectureNotice, Long> {

    //sbjno, no 조인
    @Query("SELECT lna FROM LectureNotice lna JOIN FETCH lna.subjectEntity")
    List<LectureNotice> findAllWithSubject();
    /*
    위 쿼리는 LectureNotice 엔티티를 조회하는데, 이때 subject 필드도 함께 조회하도록 하고 있습니다. ln은 LectureNotice 엔티티의 별칭이며,
    ln.subject를 통해 LectureNotice 엔티티와 관계를 가지는 Subject 엔티티도 함께 조회하라는 의미입니다.
    따라서 올바르게 작성된 쿼리는 SELECT ln입니다. 해당 쿼리는 LectureNotice 엔티티와 이와 관련된 Subject 엔티티를 함께 조회할 수 있게 해줍니다.
    */
}
