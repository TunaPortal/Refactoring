package co.refactoring.tuna.domain.tuition.vo;

import co.refactoring.tuna.domain.scholar.vo.ScholarStudentVO;
import co.refactoring.tuna.domain.scholar.vo.ScholarVO;
import co.refactoring.tuna.domain.user.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tuitionGiveVO {
	private int no;
	private String yn;
	private Date giveDate;
	private int seasonCode;
	private int scPct;
	private int stNo;
	private int scstNo;
	private int tuiNo;
	
	private StudentVO studentvo;
	private TuitionVO tuitionvo;
	private ScholarStudentVO scholarstudentvo;
	private ScholarVO scholarvo;
	
}
