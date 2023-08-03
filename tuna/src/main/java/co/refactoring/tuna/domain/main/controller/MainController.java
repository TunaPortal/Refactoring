package co.refactoring.tuna.domain.main.controller;

import co.refactoring.tuna.common.vo.ResultVo;
import co.refactoring.tuna.domain.main.dto.res.TestResultVo;
import co.refactoring.tuna.domain.main.service.MainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/main")
@Tag(name = "MAIN - 메인")
@RequiredArgsConstructor
@Log4j2
public class MainController {

    final MainService mainService;

    @PostMapping("/test")
    @Operation(summary = "테스트", description = "테스트")
    public ResultVo test(){

        return ResultVo.<TestResultVo>builder().data(null).build();
    }

}
