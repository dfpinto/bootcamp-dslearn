package com.devsuperior.dslearnbds.rosources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

	@Autowired
	private NotificationService notificationService; 
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(@RequestParam(name = "unreadOnly", defaultValue="false") Boolean unreadOnly, Pageable pageable){
		Page<NotificationDTO> dto = notificationService.notificationForCurrentUser(unreadOnly, pageable);
		return ResponseEntity.ok(dto);
	}
}
