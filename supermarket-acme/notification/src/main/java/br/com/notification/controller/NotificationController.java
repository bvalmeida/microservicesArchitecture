package br.com.notification.controller;

import br.com.notification.controller.request.NotificationRequest;
import br.com.notification.controller.response.NotificationResponse;
import br.com.notification.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
@Tag(name = "Api to management notifications", description = "Create and management notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Operation(summary = "create notification", description = "create notification")
    @ApiResponse(responseCode = "201", description = "Notification success created")
    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Calling controller to create notification {}", notificationRequest);
        this.notificationService.createNotification(notificationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "find all notifications", description = "find all notifications")
    @ApiResponse(responseCode = "200", description = "find all notifications")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotificationResponse> listAllNotification(){
        return this.notificationService.listAll();
    }

    @Operation(summary = "delete notifications by id", description = "delete any notification by id")
    @ApiResponse(responseCode = "204", description = "delete notification")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteNotification(@PathVariable Long id){
        this.notificationService.deleteNotification(id);
    }

}
