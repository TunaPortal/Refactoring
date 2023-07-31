package co.refactoring.tuna.domain.scholar.web;

import co.refactoring.tuna.domain.scholar.vo.ScholarApplyVO;
import co.refactoring.tuna.domain.user.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;


@Controller
public class ScholarController {


	@RequestMapping("/stud/scholar/applyDate")
	public String applyDate() {
		return "schedule/date/applyDate";
	}
	
	@RequestMapping("/stud/scholar/statusDate")
	public String statusDate() {
		return "schedule/date/statusDate";
	}
	
	@RequestMapping("/stud/scholar/Status")
	public String scholarshipApplicationStatus(RedirectAttributes ra,Model model, ScholarApplyVO vo) {
		return "scholarship/user/scholarshipApplicationStatus";
	}

	@RequestMapping("/stud/scholar/Application")
	public String courseBasket(RedirectAttributes ra,Model model, StudentVO vo) {
		
		return "scholarship/user/scholarshipApplication";
	}

	@RequestMapping("/stud/scholar/Apply")
	public String ScolarShipApply(RedirectAttributes ra, Model model, ScholarApplyVO vo
			) {
		return "redirect:/stud/scholar/Status";
	}


	@RequestMapping("/stud/scholar/Search")
	public String scholarshipApplicationSearch( Model model, ScholarApplyVO vo,
			@RequestParam(value = "year", required = false, defaultValue = "") String year) {

		return "scholarship/user/scholarshipApplicationSearch";
	}

	@RequestMapping("/admin/admin/scholarSearch")
	public String adminScholarshipApplicationSearch(Model model, @RequestParam Map<String, Object> params,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {

		return "scholarship/admin/adminScholarshipApplicationSearch";
	}

}
