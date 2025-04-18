package ru.surovcev.comment.log.service.service;

import org.springframework.stereotype.Service;
import ru.surovcev.comment.log.service.model.Comment;

import java.util.logging.Logger;

/**
 * Помечаем класс аннотацией @Service, чтобы создавался бин в контексте Spring
 * + объект становится целевым.
 */
@Service
public class CommentService {
    /**
     * Теперь, вместо вывода в консоль используем логгеры
     * Это объект фреймворка журналирования, которые предоставляют возможности для записи в журнал и стандартизации журнальных сообщений.
     * несколько хороших:
     * Log4j
     * Logback
     * java Logging  API
     * фреймворки журналирования совместимы со всеми java-приложениями, независимо от того, используется ли в них Spring
     */
    private Logger log =
            Logger.getLogger(CommentService.class.getName());

    public void pushComment(Comment comment) {
        log.info("Публикуемый комментарий: " + comment.getText());
    }
}
