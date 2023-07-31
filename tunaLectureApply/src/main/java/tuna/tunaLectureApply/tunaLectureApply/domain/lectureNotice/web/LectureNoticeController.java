package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.vo.LectureNoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureNoticeController {

	@Autowired
	LectureNoticeService service;


	@RequestMapping("/staff/eclass/noticeUpdate")
	public String noticeUpdateView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "staff/eclass/noticeUpdate";
	}

}
