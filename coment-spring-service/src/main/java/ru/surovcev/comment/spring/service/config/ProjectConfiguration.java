package ru.surovcev.comment.spring.service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * Класс-конфиг, в котором, для выполнения текущей задачи мы только указываем путь до классов с аннотациями @Component
 */
@Configurable
@ComponentScan(
        basePackages = { "ru.surovcev.comment.spring.service.proxies",
                "ru.surovcev.comment.spring.service.repositoies",
                "ru.surovcev.comment.spring.service.services"})
public class ProjectConfiguration {

//    /**
//     * Если реализовывать через бины, то нужно создавать бин для каждой из 2х зависимостей (CommentRepository и CommentNotificationProxy)
//     * @return
//     */
//    @Bean
//    public CommentRepository commentRepository() {
//        return new DBCommentRepositories();
//    }
//
//    @Bean
//    public CommentNotificationProxy commentNotificationProxy() {
//        return new EmailCommentNotificationProxy();
//    }
//
//    /**
//     * С помощью параметров метода, @Bean (которые теперь имеют тип интерфейса) сообщаем Spring, что нужно предоставить ссылки на бины из контекста;
//     * тип этих бинов соответствует типу этих параметров.
//     */
//    @Bean
//    public CommentEmailService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//        return new CommentEmailService(commentRepository, commentNotificationProxy);
}
