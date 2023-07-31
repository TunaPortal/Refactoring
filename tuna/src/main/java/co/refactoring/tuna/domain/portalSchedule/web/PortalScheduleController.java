package co.refactoring.tuna.domain.portalSchedule.web;

import co.refactoring.tuna.domain.portalSchedule.service.PortalScheduleService;
import co.refactoring.tuna.domain.portalSchedule.vo.PortalScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalScheduleController {

	@Autowired PortalScheduleService scheduleDao;

	
	@RequestMapping("/portalSchedule")
	public String portalSchedule(Model model,  PortalScheduleVO vo) {

		return "schedule/user/portalSchedule";
	}
	// admin
	@RequestMapping("/admin/admin/adminSchedule")
	public String adminSchedule() {
		return "schedule/admin/adminSchedule";
	}

}
