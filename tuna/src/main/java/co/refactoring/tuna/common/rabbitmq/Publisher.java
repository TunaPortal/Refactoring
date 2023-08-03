//package co.refactoring.tuna.common.rabbitmq;
//
//import co.refactoring.tuna.common.rabbitmq.vo.MQResultVo;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//@Log4j2
//public class Publisher
//{
//    private static RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    Publisher(RabbitTemplate rabbitTemplate)
//    {
//        Publisher.rabbitTemplate = rabbitTemplate;
//    }
//
//    public static boolean SendMqMsg(String topic, MQResultVo content)
//    {
//        try
//        {
//            Send(topic, content);
//        } catch (AmqpException aex)
//        {
//            return false;
//        }
//
//        return true;
//    }
//
//
//    public static void Send(String topic, MQResultVo content) throws AmqpException
//    {
//        rabbitTemplate.convertAndSend(Core.EXCHANGE_NAME, topic, content);
//    }
//
//}
