package tuna.tunaEclass.tunaEclass.web.eclass.student;


import tuna.tunaEclass.tunaEclass.web.eclass.EclassController;
import tuna.tunaEclass.tunaEclass.web.eclass.student.vo.EclassStudentHomeVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Controller
@RequestMapping("/stud/eclass")
public class EclassStudentEclassController {
	
	private static final Logger logger = LoggerFactory.getLogger(EclassController.class);

	@Autowired private MessageSourceAccessor msgAccossor;
	
	@RequestMapping("/")
	public void Eclass() {
		logger.info("eclass professor test");
	}
	
	
	@RequestMapping("/lectureNotice")
	/*public String lectureNotice(Model model, LectureNoticeVO vo, HttpServletRequest req) {*/
	public String lectureNotice(Model model, HttpServletRequest req) {

		return "eclass/stud/lectureNotice";
	}
	
	@RequestMapping("/lectureNoticeSelect")
	public String lectureNoticeSelect(Model model, HttpServletRequest req) {

		return "eclass/stud/lectureNoticeSelect";
	}
	
	@RequestMapping("/lecturePlan")
	public String lecturePlan(Model model, HttpServletRequest req) {

		return "eclass/stud/lecturePlan";
	}
	
	@RequestMapping("/qnaList")
	public String qnaList(Model model, HttpServletRequest req,
						  @RequestParam HashMap<String, Object> map,
						  @RequestParam(value="pageNum", required=false, defaultValue= "1" ) int pageNum) {

		return "eclass/stud/qnaList";
	}
	
	@RequestMapping("/qnaSelect")
	public String qnaSelect(Model model, HttpServletRequest req) {

		return "eclass/stud/qnaSelect";
	}
	
	//질의응답작성폼
	@RequestMapping("/qnaInsert")
	public String qnaInsert(Model model, RedirectAttributes redir,
							HttpServletRequest req) {

		return "eclass/stud/qnaInsert";
	}
	
	//질의응답등록
	@RequestMapping("/insertOneQna")
	public String insertOneQna(Model model, RedirectAttributes redir,
			HttpServletRequest req) {

		return "redirect:/stud/eclass/qnaSelect";
	}
	

	
	@RequestMapping("/taskList")
	public String taskList(Model model, HttpServletRequest req) {

		return "eclass/stud/taskList";
	}
	
	@RequestMapping("/taskSelect")
	public String taskSelect(Model model, HttpServletRequest req){

		return "eclass/stud/taskSelect";
	}

	//자료실
	@RequestMapping("/download") 
	public String download(Model model) {
		
		return "eclass/stud/download";
	}

	@RequestMapping("/home")
	public String home(Model model,
			EclassStudentHomeVO vo,
			HttpServletResponse res,
			@CookieValue(value="seasonCode", required=false, defaultValue="0") String seasonCode) {
		

		return "eclass/stud/home";
	}
	
	//단건강의홈
	@RequestMapping("/lectureHome")
	public String lectureHome(Model model, EclassStudentHomeVO vo, HttpServletRequest req) {
		vo.setSbjNo(Integer.parseInt(req.getParameter("sbjNo"))); 

		return "eclass/stud/lectureHome";
	}

	//출석
	@RequestMapping("/attendance")
	public String studentAttendance(Model model, HttpServletRequest req) {

		return "eclass/stud/attendance";
	}
}
