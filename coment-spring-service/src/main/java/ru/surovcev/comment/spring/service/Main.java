package ru.surovcev.comment.spring.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.surovcev.comment.spring.service.config.ProjectConfiguration;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
                ProjectConfiguration.class
        );

        var comment = new Comment();
        comment.setAuthor("Гендальф");
        comment.setContent("Тестовое сообщение");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
