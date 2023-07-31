package co.refactoring.tuna.domain.user.vo;

import co.refactoring.tuna.domain.task.vo.SubmitTaskVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithSubmitTaskVO extends StudentVO {
	
	private String stateName;
	private String bankName;
	private String deptName;
	
	private SubmitTaskVO submitTask;
}
