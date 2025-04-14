package ru.surovcev.comment.service;

import ru.surovcev.comment.service.model.Comment;
import ru.surovcev.comment.service.proxies.EmailCommentNotificationProxy;
import ru.surovcev.comment.service.repositories.DBCommentRepository;
import ru.surovcev.comment.service.services.CommentService;

public class Main {
    public static void main(String[] args) {
        /**
         * Создаём экземплляры для зависимостей.
         */
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        /**
         * Создаём экземпляр класса сервиса и предоставляем ему зависимости
         */
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        /**
         * Создаём экземпляр комментария, чтобы передать его сценарию использования (передать и сохранить комментарий) в качестве параметра.
         */
        var comment = new Comment();
        comment.setAuthor("Гендальф");
        comment.setContent("Демо комент");

        /**
         * Вызываем сценарий использования
         */
        commentService.publishComment(comment);
    }
}
