package tuna.tunaLectureApply.tunaLectureApply.domain.lectureEval.web;


import tuna.tunaLectureApply.tunaLectureApply.domain.lectureEval.vo.LectureEvalVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LectureEvalController {

	@RequestMapping("/stud/course/Evaluation")
	public String lectureEvaluation() {
		return "course/evaluation/lectureEvaluation";
	}
	
	@RequestMapping("/stud/course/Details")
	public String lectureEvaluationDetails(LectureEvalVO vo, Model model) {
		return "course/evaluation/lectureEvaluationDetails";
	}
	
	@RequestMapping("/stud/course/Search")
	public String lectureEvaluationSearch(String proNo, Model model) {
		return "course/evaluation/lectureEvaluationSearch";
	}

	@RequestMapping("/stud/course/evalSuccess")
	public String lectureEval(RedirectAttributes ra, LectureEvalVO vo) {
		return "redirect:/stud/course/Evaluation";
	}


}
