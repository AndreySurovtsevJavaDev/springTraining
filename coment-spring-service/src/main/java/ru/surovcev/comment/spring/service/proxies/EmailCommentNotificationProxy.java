package ru.surovcev.comment.spring.service.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.surovcev.comment.spring.service.model.Comment;

/**
 * Класс, который реализует интерфейс CommentNotification.
 * в Данном случае, бизнесово мы предполагаем, что отправка будет осуществляться на почту. Если нам понадобится отправлять куда-то ещё,
 * ТО мы сделаем новый класс, который так же будет имплементировать интерфейс, но будет заниматься отправкой уже в другое место.
 */

/**
 * Для класса с аннотацией @Component Spring создаст экземпляр и добавит этот экземпляр в контекст как бин
 */
@Component
@Qualifier("EMAIL")     // С помощью аннотации присвоили реализации имя (это после добавения ещё одно класса реализующего отправку)
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment){
        System.out.println("Sending comment to email: " + comment.getContent());
    }
}
