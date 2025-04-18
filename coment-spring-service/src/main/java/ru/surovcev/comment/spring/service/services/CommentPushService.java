package ru.surovcev.comment.spring.service.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.proxies.CommentNotificationProxy;
import ru.surovcev.comment.spring.service.repositoies.CommentRepository;

/**
 * Ещё один класс реализующий сценарий использования. Для реализации он использует те же классы отвечающие за конкретные действия, что и другой сервис.
 */
@Service
public class CommentPushService {
    private final CommentNotificationProxy commentNotificationProxy;


    public CommentPushService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentNotificationProxy = commentNotificationProxy;
    }

    /**
     * 6.1 Аспекты
     * класс CommentPushService (целевой объект) помещён в контекст с помощью аннотации @Service И является бином
     * Далее, пример: мы хотим, чтобы перед (после, или вместо) каждым выполнением (срез) метода publishPushComment (принадлежит бину) выполнялась (совет) ещё некая логика (аспект)
     * @param comment
     */

    public void publishPushComment(Comment comment) {
        commentNotificationProxy.sendComment(comment);
    }
}
