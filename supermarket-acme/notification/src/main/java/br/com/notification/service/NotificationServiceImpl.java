package br.com.notification.service;

import br.com.notification.config.ConvertUtils;
import br.com.notification.controller.request.NotificationRequest;
import br.com.notification.controller.response.NotificationResponse;
import br.com.notification.model.NotificationEntity;
import br.com.notification.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;
    private final ConvertUtils convertUtils;

    public NotificationServiceImpl(NotificationRepository notificationRepository, ConvertUtils convertUtils) {
        this.notificationRepository = notificationRepository;
        this.convertUtils = convertUtils;
    }


    @Override
    public NotificationResponse createNotification(NotificationRequest notificationRequest) {
        var notificationEntity = (NotificationEntity) this.convertUtils.convertRequestToEntity(notificationRequest, NotificationEntity.class);
        var entity = this.notificationRepository.save(notificationEntity);
        return (NotificationResponse) this.convertUtils.convertEntityToResponse(entity, NotificationResponse.class);
    }

    @Override
    public List<NotificationResponse> listAll() {
        List<NotificationEntity> listEntity = this.notificationRepository.findAll();
        List<NotificationResponse> listResponse = (List<NotificationResponse>) this.convertUtils.convertToListResponse(listEntity, NotificationResponse.class);
        return listResponse;
    }

    @Override
    public void deleteNotification(Long id) {
        this.notificationRepository.deleteById(id);
    }
}
