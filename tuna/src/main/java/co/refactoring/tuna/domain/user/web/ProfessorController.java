package co.refactoring.tuna.domain.user.web;

import co.refactoring.tuna.domain.user.service.ProfessorService;
import co.refactoring.tuna.domain.user.vo.ProfessorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	
	@Autowired 
	private ProfessorService professorDao;
	
	@Autowired 
	private MessageSourceAccessor msg;

	@RequestMapping("/staff/userUpdate")
	public String userUpdate(Model model, ProfessorVO vo) {

		
		return "manage/user/staffUpdate";
		
	}

	@RequestMapping("/staff/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/staffPwdUpdate";
	}

}
