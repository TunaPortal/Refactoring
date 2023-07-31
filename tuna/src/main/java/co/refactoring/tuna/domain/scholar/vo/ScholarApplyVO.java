package co.refactoring.tuna.domain.scholar.vo;

import co.refactoring.tuna.domain.user.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScholarApplyVO {
	private String no;
	private Date applyDate;
	private Date confirmDate;
	private String stateCode;
	private String fileName;
	private String uri;
	private String seasonCode;
	private String stNo;
	private String schNo;
	
	private ScholarVO scholarVO;
	private StudentVO studentVO;
}
