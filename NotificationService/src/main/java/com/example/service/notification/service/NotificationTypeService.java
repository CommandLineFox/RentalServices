package com.example.service.notification.service;

import com.example.service.notification.dto.CreateNotificationTypeDto;
import com.example.service.notification.dto.NotificationTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationTypeService {
    NotificationTypeDto dodajNotificationType(CreateNotificationTypeDto createNotificationTypeDto);

    Page<NotificationTypeDto> nadjiSveNotifikacationTYpe(Pageable pageable);

    NotificationTypeDto azurirajNotificationTYpe(NotificationTypeDto notificationTypeDto);

    NotificationTypeDto findbyname(String name);

    void deleteById(String id);
}
