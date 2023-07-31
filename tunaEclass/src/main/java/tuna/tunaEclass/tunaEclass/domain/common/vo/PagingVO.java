package tuna.tunaEclass.tunaEclass.domain.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingVO {
	private int length;
	private int pageCount;
	private int sizePerPage;
	private String tableName;
	
	public PagingVO(String tableName, int sizePerPage) {
		this.tableName = tableName;
		this.sizePerPage = sizePerPage;
	}
}
