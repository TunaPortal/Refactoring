package tuna.tunaEclass.tunaEclass.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogMsg {

    /* DB Connection Log Info */
    DB_CONFIG_LOCATION("============== DB1 config-location : {}")
    ,DB_MAPPER_LOCATION("============== DB1 mapper-location : {}")
    ,DB_SCHEMA_LOCATION("============== DB1 schema-location : {}")

    /* Mq Log Info */
    ,MQ_INFO_HOST("============== MQ HOST : {}")
    ,MQ_INFO_PORT("============== MQ PORT : {}")
    ,MQ_LISTEN_MSG("============== MQ MSG RECEIVE : [Queue] :: {}, [Content] :: {}")
    ,MQ_INFO_USERNAME("============== MQ USERNAME : {}")
    ,MQ_INFO_VIRTUALHOST("============== MQ VIRTUALHOST : {}")
    ,MQ_INFO_SEND_INFO("============== MQ MSG SEND INFO : [Topic] :: {}, [Msg] :: {}")

    /* Mq Log Error */
    ,MQ_ERROR_EXCEPTION("============== MQ EXCEPTION : {}")


    /* Default Error Log Info */
    ,SERVICE_ERROR_EXCEPTION("============== ERROR EXCEPTION : {}")

    /* DB Error Log Info */
    ,DB_ERROR("============== DB ERROR : {}")
    ,DB_ERROR_LOGOUT("============== DB 로그아웃 ERROR : {}")
    ,DB_ERROR_HIST("============== DB 이력 삽입 ERROR : {}");

    private final String logMsg;
}
