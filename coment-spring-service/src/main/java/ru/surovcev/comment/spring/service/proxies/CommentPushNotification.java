package ru.surovcev.comment.spring.service.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.surovcev.comment.spring.service.model.Comment;

/**
 * Новый класс, который имплементирует CommentNotificationProxy и занимается,как и предыдущий отправкой увдеомлений, только не на почту, а пушами в системе.
 * т.к используем мы оба, то сохранаять такие уведомления в БД ещё раз уже не нужно.
 */

@Component
@Qualifier("PUSH")
public class CommentPushNotification implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment){
        System.out.println("push comment notification: " + comment.getContent() );
    }
}
