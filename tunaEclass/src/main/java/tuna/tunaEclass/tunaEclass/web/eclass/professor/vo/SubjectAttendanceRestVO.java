package tuna.tunaEclass.tunaEclass.web.eclass.professor.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectAttendanceRestVO {
	/*List<StudentWithAttendanceVO> students;*/
	@JsonFormat(pattern = "yyyy/MM/dd", timezone="Asia/Seoul")
	LocalDate date;
}
