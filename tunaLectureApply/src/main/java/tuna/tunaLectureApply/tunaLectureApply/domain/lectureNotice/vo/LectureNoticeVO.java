package tuna.tunaLectureApply.tunaLectureApply.domain.lectureNotice.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureNoticeVO {
	private int no;
	private String title;
	private String content;
	private Date enrollDate;
	private int sbjNo;
	private int stNo;
	private int seasonCode;
	private int rowNum;
	
	/*private SubjectVO subjectVO;*/
}
