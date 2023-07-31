package co.refactoring.tuna.domain.user.web;

import co.refactoring.tuna.domain.user.service.StudentService;
import co.refactoring.tuna.domain.user.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired 
	private StudentService StudentDao;

	@RequestMapping("/stud/userUpdate")
	public String userUpdate(Model model, StudentVO vo) {
		return "manage/user/userUpdate";
	}

}
