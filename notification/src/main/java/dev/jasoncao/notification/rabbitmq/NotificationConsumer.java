package dev.jasoncao.notification.rabbitmq;

import dev.jasoncao.clients.notification.NotificationRequest;
import dev.jasoncao.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record NotificationConsumer(NotificationService notificationService) {

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Received notification request: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
