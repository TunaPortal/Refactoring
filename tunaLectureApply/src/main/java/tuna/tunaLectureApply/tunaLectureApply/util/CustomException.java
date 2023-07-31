package tuna.tunaLectureApply.tunaLectureApply.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomException extends Throwable {
	private ResponseMsg resMsg;
}
