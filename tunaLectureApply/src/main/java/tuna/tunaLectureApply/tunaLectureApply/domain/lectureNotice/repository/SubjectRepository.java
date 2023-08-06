package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {


}
