package com.topnotch.springsecuritysection2.restcontroller;

import com.topnotch.springsecuritysection2.model.Notice;
import com.topnotch.springsecuritysection2.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        return noticeRepository.findAllNotices();
    }
}
