package co.refactoring.tuna.domain.user.vo;

import co.refactoring.tuna.domain.attendance.vo.AttendanceVO;
import co.refactoring.tuna.domain.grade.vo.GradeVO;

import co.refactoring.tuna.domain.task.vo.SubmitTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentExVO extends StudentVO {
	
	private String stateName;
	private String bankName;
	private String deptName;
	
	private GradeVO gradeVO;
	private List<AttendanceVO> attendanceList;
	private List<SubmitTaskVO> submitTaskList;
	/*private List<LectureQnaVO> lectureQnaList;*/
}
