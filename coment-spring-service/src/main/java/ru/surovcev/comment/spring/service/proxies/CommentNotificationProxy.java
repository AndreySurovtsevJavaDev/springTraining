package ru.surovcev.comment.spring.service.proxies;

import ru.surovcev.comment.spring.service.model.Comment;

/**
 * Интерфейс, который сообщает, что нужно для реализации сценария использования: отправка комментария
 */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
