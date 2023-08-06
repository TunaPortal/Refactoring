package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.SubjectEntity;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecture-notices")
@Tag(name = "강의 - 공지사항")
public class LectureNoticeController {

	private final LectureNoticeService lectureNoticeService;
	private final SubjectService subjectService;

	@Autowired
	public LectureNoticeController(LectureNoticeService lectureNoticeService, SubjectService subjectService) {
		this.lectureNoticeService = lectureNoticeService;
		this.subjectService = subjectService;
	}

	// 리스트
	@GetMapping
	@Operation(summary = "리스트", description = "리스트")
	public String getAllLectureNotices(Model model) {
		List<LectureNotice> lectureNotices = lectureNoticeService.getAllLectureNoticesWithSubject();
		model.addAttribute("lectureNotices", lectureNotices);
		/*List<LectureNotice> lectureNotices = lectureNoticeService.getAllLectureNotices();
		model.addAttribute("lectureNotices", lectureNotices);*/
		return "staff/eclass/noticeList";
	}

	// 상세보기
	@GetMapping("/{id}")
	@Operation(summary = "상세보기", description = "상세보기")
	public String getLectureNoticeById(@PathVariable Long id, Model model) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		model.addAttribute("lectureNotice", lectureNotice);
		return "staff/eclass/notice";
	}

	// 등록
	@GetMapping("/new")
	@Operation(summary = "등록", description = "등록")
	public String newLectureNotice(Model model) {
		model.addAttribute("lectureNotice", new LectureNotice());
		return "staff/eclass/noticeForm";
	}

	// 등록 후 리스트로 리다이렉트
	@PostMapping
	@Operation(summary = "등록 후 리스트로", description = "등록 후 리스트로")
	public String createLectureNotice(@ModelAttribute LectureNotice lectureNotice) {
		lectureNoticeService.saveLectureNotice(lectureNotice);
		return "redirect:/lecture-notices";
	}

	// 수정
	@GetMapping("/{id}/edit")
	@Operation(summary = "수정", description = "수정")
	public String editLectureNotice(@PathVariable Long id, Model model) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		model.addAttribute("lectureNotice", lectureNotice);
		List<SubjectEntity> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "staff/eclass/noticeUpdate";
	}

	// 수정 후 리스트로 리다이렉트
	@PostMapping("/{id}/update")
	@Operation(summary = "수정 후 리스트로", description = "수정 후 리스트로")
	public String updateLectureNotice(@PathVariable Long id, @ModelAttribute LectureNotice updatedLectureNotice) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		lectureNotice.setTitle(updatedLectureNotice.getTitle());
		lectureNotice.setContent(updatedLectureNotice.getContent());
		lectureNotice.setSubjectEntity(updatedLectureNotice.getSubjectEntity());
		lectureNoticeService.saveLectureNotice(lectureNotice);
		return "redirect:/lecture-notices";
	}

	// 삭제
	@GetMapping("/{id}/delete")
	@Operation(summary = "삭제", description = "삭제")
	public String deleteLectureNotice(@PathVariable Long id) {
		lectureNoticeService.deleteLectureNotice(id);
		return "redirect:/lecture-notices";
	}
}
	/*
	@RequestMapping("/staff/eclass/noticeUpdate")
	public String noticeUpdateView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "staff/eclass/noticeUpdate";
	}

	@RequestMapping("/staff/eclass/notice")
	public String noticeView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "staff/eclass/notice";
	}

	@RequestMapping("/staff/eclass/noticeForm")
	public String noticeFormView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "staff/eclass/noticeForm";
	}

	@RequestMapping("/staff/eclass/noticeList")
	public String noticeListView(Model model, LectureNoticeVO notice) {
		model.addAttribute("notice", notice);
		return "staff/eclass/noticeList";
	}
*/



