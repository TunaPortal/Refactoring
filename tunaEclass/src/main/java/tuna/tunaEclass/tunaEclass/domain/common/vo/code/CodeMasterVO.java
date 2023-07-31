package tuna.tunaEclass.tunaEclass.domain.common.vo.code;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeMasterVO {
	private String no;
	private String codeName;
	
	private ArrayList<CodeVO> children;
}
