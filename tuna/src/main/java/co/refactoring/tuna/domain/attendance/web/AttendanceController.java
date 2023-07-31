package co.refactoring.tuna.domain.attendance.web;

import co.refactoring.tuna.domain.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AttendanceController {

	@Autowired
	AttendanceService service;
	
	/*@ResponseBody
	@PostMapping("/staff/attendance")
	public SubjectAttendanceRestVO getAttendance(
			@RequestBody Map<String, Integer> reqData) {


		return new SubjectAttendanceRestVO();
	}*/
}
