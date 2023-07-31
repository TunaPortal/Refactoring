package co.refactoring.tuna.domain.task.vo;

import java.util.List;

import co.refactoring.tuna.domain.user.vo.StudentVO;
import co.refactoring.tuna.domain.user.vo.StudentWithSubmitTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EclassTaskContentVO {
	private List<TaskVO> tasks;
	private List<StudentWithSubmitTaskVO> students;
}
