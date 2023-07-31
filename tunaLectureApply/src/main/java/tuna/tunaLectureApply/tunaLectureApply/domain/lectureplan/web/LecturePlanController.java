package tuna.tunaLectureApply.tunaLectureApply.domain.lectureplan.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureplan.vo.LecturePlanVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LecturePlanController {

	@RequestMapping("/stud/course/plan")
	public String CoursePlan(Model model, LecturePlanVO vo) {
		return "course/apply/coursePlan";
	}
}
