package dev.jasoncao.notification;

import dev.jasoncao.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("jasoncao")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
