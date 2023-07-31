package co.refactoring.tuna.domain.banner.vo;

import java.sql.Date;

import co.refactoring.tuna.domain.user.vo.AdminVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerVO {
	private int no;
	private String bannerCode;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	private Date enrollDate;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	private Date endDate;
	private String fileName;
	private String uri;
	private String url;
	private int sequence;
	private String adNo;
	
	private AdminVO admin;
}
