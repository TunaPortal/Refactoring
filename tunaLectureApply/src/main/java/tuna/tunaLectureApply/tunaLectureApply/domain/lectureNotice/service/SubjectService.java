package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.SubjectEntity;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {

        this.subjectRepository = subjectRepository;
    }


    // find.All() = 전체 다 SELECT
    public List<SubjectEntity> getAllSubjects() {

        return subjectRepository.findAll();
    }

    // findById() = 1건 조회
    public SubjectEntity getSubjectById(long id) {

        return subjectRepository.findById(id).orElse(null);
    }

    // save = 등록, 수정
    // 값이 없으면 등록, 값이 있으면 수정
    public SubjectEntity saveSubject(SubjectEntity subjectEntity) {

        return subjectRepository.save(subjectEntity);
    }

    // deleteById = 1건 삭제
    public void deleteSubject(long id) {

        subjectRepository.deleteById(id);
    }
}
