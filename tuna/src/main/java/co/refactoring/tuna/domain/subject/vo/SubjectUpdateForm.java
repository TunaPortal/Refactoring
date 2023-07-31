package co.refactoring.tuna.domain.subject.vo;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectUpdateForm {
	private GradeRatioVO gradeRatio;
	/*private List<LecturePlanVO> plans;*/
}
