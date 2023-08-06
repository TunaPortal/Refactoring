package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.repository.LectureNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureNoticeService {
    private final LectureNoticeRepository lectureNoticeRepository;

    @Autowired
    public LectureNoticeService(LectureNoticeRepository lectureNoticeRepository) {
        this.lectureNoticeRepository = lectureNoticeRepository;
    }

    // 조인 셀렉트
    public List<LectureNotice> getAllLectureNoticesWithSubject() {
        return lectureNoticeRepository.findAllWithSubject();
    }

    // 모든 LectureNotice 조회
    public List<LectureNotice> getAllLectureNotices() {

        return lectureNoticeRepository.findAll();
    }

    // 특정 LectureNotice 조회
    public LectureNotice getLectureNoticeById(Long id) {

        return lectureNoticeRepository.findById(id).orElse(null);
    }

    // LectureNotice 저장 (새로운 데이터 또는 기존 데이터 수정)
    public LectureNotice saveLectureNotice(LectureNotice lectureNotice) {
        return lectureNoticeRepository.save(lectureNotice);
    }

    // 특정 LectureNotice 삭제
    public void deleteLectureNotice(Long id) {

        lectureNoticeRepository.deleteById(id);
    }

    //TDD에서 쿼리문 작동 보기 ?
    public LectureNotice updateLectureNotice(Long id, LectureNotice updatedLectureNotice) {
        LectureNotice lectureNotice = lectureNoticeRepository.findById(id).orElse(null);
        if (lectureNotice != null) {
            lectureNotice.setTitle(updatedLectureNotice.getTitle());
            lectureNotice.setContent(updatedLectureNotice.getContent());
            lectureNotice.setSubjectEntity(updatedLectureNotice.getSubjectEntity());
            return lectureNoticeRepository.save(lectureNotice);
        }
        return null;
    }

}