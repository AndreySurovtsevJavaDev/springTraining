package ru.surovcev.comment.log.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.surovcev.comment.log.service.config.ProjectConfig;
import ru.surovcev.comment.log.service.model.Comment;
import ru.surovcev.comment.log.service.service.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Гендальф");
        comment.setText("Пушка");

        service.pushComment(comment);
    }
}
