package dev.jasoncao.clients.notification;

import lombok.Builder;

@Builder
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message) {
}
