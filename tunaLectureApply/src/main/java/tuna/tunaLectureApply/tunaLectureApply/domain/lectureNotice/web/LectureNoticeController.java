package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.LectureNotice;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.entity.SubjectEntity;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.LectureNoticeService;
import tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
//@RequestMapping("/lecture-notices")
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
	@GetMapping("/selectLectureNoticeList")
	@Operation(summary = "리스트", description = "리스트")
	public ResponseEntity<List<LectureNotice>> getAllLectureNotices(Model model) {
		List<LectureNotice> lectureNotices = lectureNoticeService.getAllLectureNoticesWithSubject();
		model.addAttribute("lectureNotices", lectureNotices);
		/*List<LectureNotice> lectureNotices = lectureNoticeService.getAllLectureNotices();
		model.addAttribute("lectureNotices", lectureNotices);*/
		//return "staff/eclass/noticeList";
		return ResponseEntity.ok(lectureNotices);
	}

	// 상세보기
	@GetMapping("/selectLectureNoticeSelect/{id}")
	public ResponseEntity<LectureNotice> getLectureNoticeById(@PathVariable Long id) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		if (lectureNotice != null) {
			return ResponseEntity.ok(lectureNotice);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	// 등록
	@GetMapping("/selectLectureNoticeInsert")
	public ResponseEntity<LectureNotice> newLectureNotice() {
		LectureNotice lectureNotice = new LectureNotice();
		return ResponseEntity.ok(lectureNotice);
	}

	// 수정
	@GetMapping("/selectLectureNoticeUpdate/{id}")
	public ResponseEntity<LectureNotice> editLectureNotice(@PathVariable Long id) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		if (lectureNotice != null) {
			List<SubjectEntity> subjects = subjectService.getAllSubjects();
			//lectureNotice.setSubjects(subjects);
			return ResponseEntity.ok(lectureNotice);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 삭제
	@GetMapping("/selectLectureNoticeDelete/{id}")
	// Void를 사용한 이유 = 해당 메서드가 반환하는데 반환할 데이터가 없음을 나타내기 위해.
	// 204 코드를 반환하는데 204 코드는 요청은 성공했지만 본문에는 데이터가 없음을 의미
	// 삭제 됐으니까 데이터 없겠지 ㅇㅈ?
	public ResponseEntity<Void> deleteLectureNotice(@PathVariable Long id) {
		lectureNoticeService.deleteLectureNotice(id);
		return ResponseEntity.ok().build();
	}
}
	/*
	@GetMapping("/selectLectureNoticeInsert")
	@Operation(summary = "등록", description = "등록")
	public String newLectureNotice(Model model) {
		model.addAttribute("lectureNotice", new LectureNotice());
		return "staff/eclass/noticeForm";
	}
	 */

	// 등록 후 리스트로 리다이렉트
	/*
	@PostMapping
	@Operation(summary = "등록 후 리스트로", description = "등록 후 리스트로")
	public String createLectureNotice(@ModelAttribute LectureNotice lectureNotice) {
		lectureNoticeService.saveLectureNotice(lectureNotice);
		return "redirect:/lecture-notices";
	}
	 */

	
	/*
	@GetMapping("/selectLectureNoticeUpdate/{id}")
	@Operation(summary = "수정", description = "수정")
	public String editLectureNotice(@PathVariable Long id, Model model) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		model.addAttribute("lectureNotice", lectureNotice);
		List<SubjectEntity> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "staff/eclass/noticeUpdate";
	}
	 */

	/*
	// 수정 후 리스트로 리다이렉트
	@PostMapping("/{id}/update")
	@Operation(summary = "수정 후 리스트로", description = "수정 후 리스트로")
	public String updateLectureNotice(@PathVariable Long id, @RequestBody LectureNotice updatedLectureNotice) {
		LectureNotice lectureNotice = lectureNoticeService.getLectureNoticeById(id);
		lectureNotice.setTitle(updatedLectureNotice.getTitle());
		lectureNotice.setContent(updatedLectureNotice.getContent());
		lectureNotice.setSubjectEntity(updatedLectureNotice.getSubjectEntity());
		lectureNoticeService.saveLectureNotice(lectureNotice);
		return "redirect:/lecture-notices";
	}
	 */

	// 삭제
	/*
	@GetMapping("/selectLectureNoticeDelete/{id}")
	@Operation(summary = "삭제", description = "삭제")
	public String deleteLectureNotice(@PathVariable Long id) {
		lectureNoticeService.deleteLectureNotice(id);
		return "redirect:/selectLectureNoticeList";
	}
}
	 */
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



