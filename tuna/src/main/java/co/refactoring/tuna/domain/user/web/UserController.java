package co.refactoring.tuna.domain.user.web;

import co.refactoring.tuna.domain.user.vo.AdminVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class UserController {


	@RequestMapping("/admin/admin/userSearch")
	public String adminUserSearch(Model model, @RequestParam Map<String, Object> params, @RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum) {
		

		return "manage/admin/adminUserSearch";
	}
	
	@RequestMapping("/admin/admin/userInfo")
	public String adminUserInfo(Model model,String no) {
		
		if(no.length() == 5) {
			return "manage/admin/profInfo";
		}else {
			return "manage/admin/studentInfo";
		}
	}
	

	@RequestMapping("/admin/adminUpdate")
	public String adminUpdate(Model model, AdminVO vo) {
		return "manage/user/adminUpdate";
	}
	
	@RequestMapping("/admin/pwdUpdate")
	public String pwdUpdate() {
		return "manage/user/adminPwdUpdate";
	}

}
