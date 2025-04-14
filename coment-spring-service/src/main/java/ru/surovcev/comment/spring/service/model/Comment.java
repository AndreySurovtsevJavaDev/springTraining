package ru.surovcev.comment.spring.service.model;

/**
 * POJO класс. Данный объект описывается только своими атрибутами и методами.
 * Здесь мы описываем из чего будет состоять комментарий - и автора и непосредственно текста (контент).
 */
public class Comment {
    private String author;
    private String content;

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
}
