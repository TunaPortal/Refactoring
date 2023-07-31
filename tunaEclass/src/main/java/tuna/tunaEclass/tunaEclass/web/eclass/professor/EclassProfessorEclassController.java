package tuna.tunaEclass.tunaEclass.web.eclass.professor;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staff/eclass")
public class EclassProfessorEclassController {

	private static final String WEB_PATH = "/staff/eclass";

	private static final Logger logger = LoggerFactory.getLogger(EclassProfessorEclassController.class);

	@GetMapping(value = { "", "/", "/home" })
	public String homeView(Model model, HttpServletRequest req, Authentication auth) {
		return WEB_PATH + "/home";
	}

	@GetMapping("/notice")
	public String noticeView(Model model, HttpServletRequest req, @RequestParam(value = "no") int no) {

		return req.getServletPath();
	}

	@GetMapping("/noticeForm")
	public String noticeFormView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "sbjno", required = false, defaultValue = "0") int sbjno) {

		return req.getServletPath();
	}

	@GetMapping("/noticeList")
	public String noticeListView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {

		return req.getServletPath();
	}

	@GetMapping("/qna")
	/*public String qnaView(Model model, HttpServletRequest req, LectureQnaVO qna) {*/
	public String qnaView(Model model, HttpServletRequest req) {

		return req.getServletPath();
	}

	@GetMapping("/qnaList")
	public String qnaListView(Model model, HttpServletRequest req, Authentication auth) {

		return req.getServletPath();
	}

	@GetMapping("/studentList")
	public String studentListView(Model model, HttpServletRequest req) {

		return req.getServletPath();
	}

	@GetMapping("/subject")
	public String subjectView(Model model, HttpServletRequest req,
			@RequestParam(value = "no", required = false, defaultValue = "0") int sbjno) {

		return req.getServletPath();
	}

	@GetMapping("/subjectForm")
	public String subjectFormView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "no", required = false, defaultValue = "0") int no) {

		return req.getServletPath();
	}

	@GetMapping("/subjectList")
	public String subjectListView(Model model, HttpServletRequest req, Authentication auth,
			@RequestParam(value = "season", required = false, defaultValue = "0") int season) {

		return req.getServletPath();
	}

	@GetMapping("/objectionList")
	public String objectionListView(HttpServletRequest req, Authentication authentication, Model model) {

		return req.getServletPath();
	}

}
