//package co.refactoring.tuna.common.rabbitmq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@EnableRabbit
//@Configuration
//public class Core
//{
//    public static final String EXCHANGE_NAME = "amq.topic";
//    public static final String AVL_QUEUE_NAME = "avl-queue";
//
//    public static final String COMMON_QUEUE_NAME = "common-queue";
//    public static final String QUEUE_NAME = "d-queue";
//
//    public static final String AVL_TOPIC = "avl.#";
//
//    public static final String COMMON_TOPIC = "common.#";
//
//    public static final String TOPIC = "#";
//
//
//    @Bean
//    public TopicExchange exchange()
//    {
//        return new TopicExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Queue queue()
//    {
//        return new Queue(AVL_QUEUE_NAME);
//    }
//
//    @Bean
//    public Queue avl_queue()
//    {
//        return new Queue(COMMON_QUEUE_NAME);
//    }
//
//    @Bean
//    public Queue common_queue()
//    {
//        return new Queue(QUEUE_NAME);
//    }
//
//    @Bean
//    public Binding commonBinding()
//    {
//        return BindingBuilder.bind(common_queue()).to(exchange()).with(COMMON_TOPIC);
//    }
//
//    @Bean
//    public Binding avlBinding()
//    {
//        return BindingBuilder.bind(avl_queue()).to(exchange()).with(AVL_TOPIC);
//    }
//    @Bean
//    public Binding binding()
//    {
//        return BindingBuilder.bind(queue()).to(exchange()).with(TOPIC);
//    }
//
//    @Bean
//    public MessageConverter messageConverter()
//    {
//        return new Jackson2JsonMessageConverter();
//    }
//
////    @Bean
////    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
////                                             MessageListenerAdapter listenerAdapter)
////    {
////        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
////        container.setConnectionFactory(connectionFactory);
////        container.setQueueNames(QUEUE_NAME);
////        container.setMessageListener(listenerAdapter);
////        return container;
////    }
////
////
////    @Bean
////    MessageListenerAdapter listenerAdapter(AMQPReceiver receiver)
////    {
////        return new MessageListenerAdapter(receiver, messageConverter());
////    }
//
//
//}
