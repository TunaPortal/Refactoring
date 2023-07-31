package co.refactoring.tuna.domain.tuition.web;

import co.refactoring.tuna.domain.user.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TuitionController {



	@RequestMapping("/stud/tuition/Check")
	public String adminScholarshipApplicationSearch(Model model, StudentVO vo) {
		return "scholarship/user/tuitionCheck";
	}
	
	
}
