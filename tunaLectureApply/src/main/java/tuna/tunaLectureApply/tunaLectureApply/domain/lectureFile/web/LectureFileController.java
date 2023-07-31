package tuna.tunaLectureApply.tunaLectureApply.domain.lectureFile.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureFile.service.LectureFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LectureFileController {

	@Autowired LectureFileService lectureFileService;

}
