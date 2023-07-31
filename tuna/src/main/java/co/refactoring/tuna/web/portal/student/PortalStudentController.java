package co.refactoring.tuna.web.portal.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalStudentController {
	
	private static Logger logger = LoggerFactory.getLogger(PortalStudentController.class); 
	
	@Autowired private MessageSourceAccessor msgAccessor;
	
	// 강의/성적 조회
	@RequestMapping("/stud/portal/subjectAndReport")
	public String subjectAndRoport(Model model) {

		return "portal/stud/subjectAndReport";
	}

	@RequestMapping("/stud/portal/gradeReport")
	public String gradeReport(Model model) {

		return "portal/stud/gradeReport";
	}

	@RequestMapping("/stud/portal/lecturePlanList")
	public String lecturePlanList(Model model) {

		return "portal/stud/lecturePlanList";
	}

	@RequestMapping("/stud/portal/mySubjectList")
	public String mySubjectList(Model model) {

		return "portal/stud/mySubjectList";
	}
	
	// 당해학기 성적 조회
	@RequestMapping("/stud/portal/currentSemesterGrade")
	public String currentSemesterGrade(Model model) {
		return "portal/stud/currentSemesterGrade";
	}
	
}
