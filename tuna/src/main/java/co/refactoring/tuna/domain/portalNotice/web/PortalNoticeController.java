package co.refactoring.tuna.domain.portalNotice.web;

import co.refactoring.tuna.domain.portalNotice.service.PortalNoticeService;
import co.refactoring.tuna.domain.portalNotice.vo.PortalNoticeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalNoticeController {

	private static Logger logger = LoggerFactory.getLogger(PortalNoticeController.class);

	@Autowired
	private PortalNoticeService noticeDao;

	// 단건조회
	@RequestMapping("/portalNoticeSelect")
	public String portalNoticeSelect(PortalNoticeVO vo, Model model) {
		
		return "notice/user/portalNoticeSelect";
	}

	@RequestMapping("/portalNoticeList")
	public String portalNoticeList(PortalNoticeVO vo, Model model) {

		return "notice/user/portalNoticeList";
	}

	// admin
	// 전체조회
	@RequestMapping("/admin/admin/adminNoticeList")
	public String adminNoticeList(Model model, PortalNoticeVO vo) {

		return "notice/admin/adminNoticeList";
	}

	// 단건조회
	@RequestMapping("/admin/admin/adminNoticeSelect")
	public String adminNoticeSelect(PortalNoticeVO vo, Model model) {

		return "notice/admin/adminNoticeSelect";
	}

	// 공지등록폼
	@RequestMapping("/admin/admin/adminNoticeInsertForm")
	public String adminNoticeInsertForm() {
		return "notice/admin/adminNoticeInsert";
	}

	// 공지수정폼
	@PostMapping("/admin/admin/adminNoticeUpdateForm")
	public String adminNoticeUpdateForm(PortalNoticeVO vo, Model model) {

		return "notice/admin/adminNoticeUpdate";
	}


}
