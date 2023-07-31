package co.refactoring.tuna.domain.objection.vo;

import co.refactoring.tuna.domain.user.vo.StudentVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectionVO {
	private int no;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date enrollDate;
	private String content;
	private String answer;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date answerDate;
	private String seasonCode;
	private int stNo;
	private int sbjNo;
	
	private String alphabet;
	private double score;
	StudentVO student;
	
	private String objState;
}
