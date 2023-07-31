package co.refactoring.tuna.domain.subject.vo;

import co.refactoring.tuna.domain.attendance.vo.AttendanceVO;
import co.refactoring.tuna.domain.grade.vo.GradeVO;

import co.refactoring.tuna.domain.task.vo.SubmitTaskWithTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectWithAttendanceVO extends SubjectVO{
	
	private List<AttendanceVO> attendanceList;
	private GradeVO grade;
	private List<SubmitTaskWithTaskVO> submitTaskList;
	/*private List<LectureQnaVO> qnaList;*/
}
