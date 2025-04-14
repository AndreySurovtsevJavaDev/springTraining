package ru.surovcev.comment.spring.service.repositoies;

import ru.surovcev.comment.spring.service.model.Comment;

/**
 * Интерфейс, который сообщает, что нужно для реализации сценария использования: Сохранение комментария
 */
public interface CommentRepository {
    void storeComment(Comment comment);
}
