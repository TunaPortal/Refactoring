package tuna.tunaLectureApply.tunaLectureApply.domain.lectureQna.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LectureQnaVO {
	private int no;
	
	
	private String title;
	private String content;
	private Date enrollDate;
	private String answer;
	private Date answerDate;
	private int stNo;
	private String sbjNo;
	private int visible;
	private int rowNum;
	
	/*private StudentVO studentVO;
	private SubjectVO subjectVO;*/
}
