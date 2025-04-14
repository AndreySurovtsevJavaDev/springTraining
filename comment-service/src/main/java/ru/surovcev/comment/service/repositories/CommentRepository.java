package ru.surovcev.comment.service.repositories;

import ru.surovcev.comment.service.model.Comment;

/**
 * Репозиторий для работы с комментариями
 */
public interface CommentRepository {
    /**
     * Сообщает, что нужно объекту CommentService для реализации сценария использования: сохранение комментария.
     * @param comment
     */
    void storeComment(Comment comment);
}
