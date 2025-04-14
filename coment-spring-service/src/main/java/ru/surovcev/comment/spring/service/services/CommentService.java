package ru.surovcev.comment.spring.service.services;

import org.springframework.stereotype.Component;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.proxies.CommentNotificationProxy;
import ru.surovcev.comment.spring.service.repositoies.CommentRepository;

/**
 * Класс реализующий сценарий использования. Для реализации он использует классы отвечающие за конкретные действия.
 * т.е что-то типо класса-менеджера, который даёт распоряжения на выполнение задач подчинённым классам, не вдаваясь в детали, как они это будут делать.
 */
@Component
public class CommentService {
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
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    /**
     * Метод, который вызывает методы подчинённых классов (та самая задача от менеджера подчинённому - что-то сделать)
     * @param comment
     */
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
