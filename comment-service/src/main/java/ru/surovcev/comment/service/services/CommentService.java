package ru.surovcev.comment.service.services;

import ru.surovcev.comment.service.model.Comment;
import ru.surovcev.comment.service.proxies.CommentNotificationProxy;
import ru.surovcev.comment.service.repositories.CommentRepository;

public class CommentService {
    /**
     * Зависимости в виде 2х атрибутов класса
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /**
     * Предоставляем эти зависимости в момент создания объекта посредством параметров конструктора
     * @param commentRepository
     * @param commentNotificationProxy
     */
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    /**
     * Реализуем сценарий использования, который делегирует зависимостям обязанности: сохранить и отправить комментарий.
     * @param comment
     */
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
