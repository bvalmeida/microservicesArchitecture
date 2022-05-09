package br.com.notification.service;

import br.com.notification.controller.request.NotificationRequest;
import br.com.notification.controller.response.NotificationResponse;

import java.util.List;

public interface NotificationService {

    NotificationResponse createNotification(NotificationRequest notificationRequest);
    List<NotificationResponse> listAll();

}
