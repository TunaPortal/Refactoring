package co.refactoring.tuna.common.rabbitmq;


import co.refactoring.tuna.common.rabbitmq.vo.MQResultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Component
@Log4j2
public class Receiver
{
    private final CountDownLatch latch = new CountDownLatch(1);
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = Core.AVL_QUEUE_NAME)
    public void avlMessage(Message message)
    {
        String content = new String(message.getBody());
        if (message.getMessageProperties().getReceivedRoutingKey().equals("tuna.mq.test")) {
            System.out.println("tuna.mq.test 토픽받았다.");
        }
        try
        {
            log.info("Received <" + message + ">");
            MQResultVo model = objectMapper.readValue(message.getBody(), MQResultVo.class);
            log.info("Received <" + model.toString() + ">");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void handleMessage(String message)
    {
        log.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch()
    {

        return latch;
    }

}