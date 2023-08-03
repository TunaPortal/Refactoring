package co.refactoring.tuna.domain.main.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class TestResultVo {

    @Schema(description = "테스트용 필드값")
    public String test;
}
