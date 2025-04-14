package ru.surovcev.comment.service.proxies;

import ru.surovcev.comment.service.model.Comment;

/**
 * Интерфейс для работы с
 */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
