package es.uv.bjtwcam.colas.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name.file}")
    private String queueFile;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.file}")
    private String file;

    @SuppressWarnings("unused")
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Bean
    public void Configure() {
     Queue q = new Queue(this.queueFile, true, false, false);
     amqpAdmin.declareQueue(q);

     TopicExchange e = new TopicExchange(this.exchange);
     amqpAdmin.declareExchange(e);

     amqpAdmin.declareBinding(BindingBuilder
                              .bind(q)
                              .to(e)
                              .with(this.file));
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
     return new Jackson2JsonMessageConverter();
    }
    
}
