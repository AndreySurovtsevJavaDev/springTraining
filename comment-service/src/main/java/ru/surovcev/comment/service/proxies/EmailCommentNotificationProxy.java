package ru.surovcev.comment.service.proxies;

import ru.surovcev.comment.service.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getContent());
    }
}
