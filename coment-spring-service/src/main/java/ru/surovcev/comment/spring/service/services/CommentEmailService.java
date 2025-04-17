package ru.surovcev.comment.spring.service.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.proxies.CommentNotificationProxy;
import ru.surovcev.comment.spring.service.repositoies.CommentRepository;

/**
 * Класс реализующий сценарий использования. Для реализации он использует классы отвечающие за конкретные действия.
 * т.е что-то типо класса-менеджера, который даёт распоряжения на выполнение задач подчинённым классам, не вдаваясь в детали, как они это будут делать.
 */
@Component
public class CommentEmailService {
    /**
     * Зависимости в виде 2х атрибутов класса.
     * Передаются извне (те самые DI)
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /**
     * Конструктор класса. Если бы у класса было несколько конструкторов, то пришлось бы использовать аннотацию @autowired
     * (Если конструкторов несколько, Spring не знает, какой выбрать, и выбрасывает исключение)
     * @param commentRepository
     * @param commentNotificationProxy
     */
    /**
     * Т.к добавились специальные реализации, теперь нужно сопровождать эти реализации @Qualifier
     * @param commentRepository
     * @param commentNotificationProxy
     */
    public CommentEmailService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    /**
     * Метод, который вызывает методы подчинённых классов (та самая задача от менеджера подчинённому - что-то сделать)
     * @param comment
     */
    public void publishEmailComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
