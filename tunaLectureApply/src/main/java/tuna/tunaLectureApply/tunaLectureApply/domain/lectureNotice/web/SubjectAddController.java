package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.SubjectEntity;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectAddController {
    private final SubjectService subjectService;

    public SubjectAddController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectEntity> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public SubjectEntity getSubject(@PathVariable int id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public SubjectEntity saveSubject(@RequestBody SubjectEntity subjectEntity) {
        return subjectService.saveSubject(subjectEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable int id) {
        subjectService.deleteSubject(id);
    }
}
