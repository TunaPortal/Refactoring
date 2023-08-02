package co.refactoring.tuna.common.rabbitmq.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MQResultVo<T>
{
    @Schema(description = "사용자 아이디 (교수,학생,관리자)")
    public String userId = "";
}
