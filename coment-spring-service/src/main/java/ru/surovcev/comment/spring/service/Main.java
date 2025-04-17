package ru.surovcev.comment.spring.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.surovcev.comment.spring.service.config.ProjectConfiguration;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.services.CommentEmailService;
import ru.surovcev.comment.spring.service.services.CommentPushService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
                ProjectConfiguration.class
        );

        var comment = new Comment();
        comment.setAuthor("Гендальф");
        comment.setContent("Тестовое сообщение");

        var commentEmailService = context.getBean(CommentEmailService.class);
        commentEmailService.publishEmailComment(comment);

        var commentPushService = context.getBean(CommentPushService.class);
        commentPushService.publishPushComment(comment);
    }
}
