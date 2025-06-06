package ru.surovcev.comment.spring.service.repositoies;

import org.springframework.stereotype.Repository;
import ru.surovcev.comment.spring.service.model.Comment;

/**
 * Класс, который реализует интерфейс CommentRepository
 * В данном случае бизнесово он отвечает за сохранение комментария в БД (Что нужно для рализации сценария мы наследуем из интерфейса)
 */

/**
 * Для класса с аннотацией @Component Spring создаст экземпляр и добавит этот экземпляр в контекст как бин
 * @Component был заменён на @Repository, чтобы дать дополнительную информацию, что основная задача объектов помеченных этой аннотацией - сохранять данные
 */
@Repository
public class DBCommentRepositories implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Коммент сохранён " + comment.getContent());
    }
}
