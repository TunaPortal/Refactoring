package tuna.tunaLectureApply.tunaLectureApply.domain.lectureApply.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureApply.vo.LectureApplyVO;

import java.util.Map;

@Controller
public class LectureApplyController {


	@RequestMapping("/stud/course/Warning")
	public String courseWarning() {
		return "course/apply/courseWarning";
	}

	@RequestMapping("/stud/date/courseDate")
	public String courseDate() {
		return "schedule/date/courseDate";
	}


	@RequestMapping("/stud/course/Application")
	public String courseApplication(RedirectAttributes ra, Model model, LectureApplyVO vo, @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
									@RequestParam Map<String, Object> params ) {

		return "course/apply/courseApplication";
	}

	@RequestMapping("/stud/course/ApplySchedule")
	public String courseApplicationSchedule() {
		return "course/apply/courseApplicationSchedule";
	}

	@RequestMapping("/stud/course/ApplicationLectureList")
	public String courseApplicationLectureList() {
		return "course/apply/courseApplicationLectureList";
	}


}
