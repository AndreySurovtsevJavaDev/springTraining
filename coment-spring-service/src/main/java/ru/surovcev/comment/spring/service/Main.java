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

        /**
         * Здесь созданы доп экземпляры для экспериментов с областями видимости (scope)
         * при SCOPE_PROTOTYPE при каждом вызове метода getBean будет создаваться новый экземпляр
         * CommentEmailService работает с прототипной областью видимости, а CommentPushService с одиночной. Результат в консоли, при запуске:
         */

        var commentEmailService1= context.getBean(CommentEmailService.class);
        var commentPushService1= context.getBean(CommentPushService.class);

        System.out.println(commentEmailService == commentEmailService1);    // Здесь false, т.к при каждом вызове getBean создавался новый экземпляр
        System.out.println(commentPushService == commentPushService1);      // Здесь true т.к бин один и тот же

    }
}
