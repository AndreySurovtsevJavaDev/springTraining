package ru.surovcev.comment.spring.service.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.surovcev.comment.spring.service.model.Comment;
import ru.surovcev.comment.spring.service.proxies.CommentNotificationProxy;
import ru.surovcev.comment.spring.service.repositoies.CommentRepository;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * Класс реализующий сценарий использования. Для реализации он использует классы отвечающие за конкретные действия.
 * т.е что-то типо класса-менеджера, который даёт распоряжения на выполнение задач подчинённым классам, не вдаваясь в детали, как они это будут делать.
 */
@Service    // Стереотипная аннотация. Даёт дополнительную информацио о том, что задача объектов этого класса - это реализация сценариев использования
//@Lazy   // с данной аннотацией Spring создаст бин, только когда потребуется его использовать.
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentEmailService {
    /**
     * Зависимости в виде 2х атрибутов класса.
     * Передаются извне (те самые DI)
     */
    /**
     * Final даёт понять, что бины не должны быть изменяемыми.
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /**
     * Конструктор класса. Если бы у класса было несколько конструкторов, то пришлось бы использовать аннотацию @autowired
     * (Если конструкторов несколько, Spring не знает, какой выбрать, и выбрасывает исключение)
     * @param commentRepository
     * @param commentNotificationProxy
     */
    /**
     * Т.к добавились специальные реализации, теперь нужно сопровождать эти реализации @Qualifier
     * @param commentRepository
     * @param commentNotificationProxy
     */
    public CommentEmailService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("comment email service bin created");    // вспомогательный текст для проверки создания бина.
    }

    /**
     * Метод, который вызывает методы подчинённых классов (та самая задача от менеджера подчинённому - что-то сделать)
     * @param comment
     */
    public void publishEmailComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
