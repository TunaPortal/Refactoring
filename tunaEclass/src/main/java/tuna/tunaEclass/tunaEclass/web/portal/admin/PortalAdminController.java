package tuna.tunaEclass.tunaEclass.web.portal.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortalAdminController {
	
	private static Logger logger = LoggerFactory.getLogger(PortalAdminController.class); 
	

	// 배너 리스트
	@GetMapping("/admin/admin/bannerList")
	public String bannerList(Model model, 
							 @RequestParam(required = false, defaultValue = "1") int page,
			                 @RequestParam(required = false, defaultValue = "1") int range,
			                 @RequestParam(required = false, defaultValue = "all") String bannerCode) {
		
		return "banner/admin/bannerList";
		
	}
	
	// 기본 배너
	@RequestMapping("/admin/admin/basicBannerManagm")
	public String basicBannerManagm() {
		return "banner/admin/basicBannerManagm";
	}
	
	// 옵션 배너
	@RequestMapping("/admin/admin/optionBannerManagm")
	public String optionBannerManagm() {
		return "banner/admin/optionBannerManagm";
	}
	
	// 슬라이드 배너
	@RequestMapping("/admin/admin/sliderBannerManagm")
	public String sliderBannerManagm(Model model) {
		return "banner/admin/sliderBannerManagm";
	}
	
}
