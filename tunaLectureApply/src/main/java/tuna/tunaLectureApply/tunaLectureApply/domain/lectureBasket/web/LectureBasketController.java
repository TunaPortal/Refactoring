package tuna.tunaLectureApply.tunaLectureApply.domain.lectureBasket.web;

import tuna.tunaLectureApply.tunaLectureApply.domain.lectureBasket.vo.LectureBasketVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LectureBasketController {


	@RequestMapping("/stud/date/basketDate")
	public String basketDate() {
		return "schedule/date/basketDate";
	}
	
	@RequestMapping("/stud/course/Basket")
	public String courseBasket(Model model, LectureBasketVO vo) {
		return "course/basket/courseBasket";
	}

	@SuppressWarnings({ "null"})


	@RequestMapping("/stud/course/BasketLectureList")
	public String courseBasketLectureList(Model model, LectureBasketVO vo) {
		return "course/basket/courseBasketLectureList";
	}
	
	@RequestMapping("/stud/course/BasketSchedule")
	public String courseBasketSchedule(Model model, LectureBasketVO vo) {
		return "course/basket/courseBasketSchedule";
	}

}
