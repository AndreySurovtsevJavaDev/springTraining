package ru.surovcev.comment.service.repositories;

import ru.surovcev.comment.service.model.Comment;

/**
 * Класс для работы с БД
 */
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment){System.out.println("Сохранён комментарий: " + comment.getContent());}
}
