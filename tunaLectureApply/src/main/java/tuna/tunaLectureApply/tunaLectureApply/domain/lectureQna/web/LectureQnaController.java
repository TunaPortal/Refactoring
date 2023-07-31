package tuna.tunaLectureApply.tunaLectureApply.domain.lectureQna.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureQna.service.LectureQnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LectureQnaController {

	@Autowired LectureQnaService lecQnaService;
	
}
