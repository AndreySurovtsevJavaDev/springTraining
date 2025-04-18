package ru.surovcev.comment.log.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

/**
 * Класс нужен для перехвата вызова метода (у целевого объекта) и вывода сообщений до и после выполнения метода
 * В нём находятся методы, которые вызов заданного метода и добавлять в него свою логику
 */

/**
 * Аннотация @Aspect не является стереотипной.
 * С её помощью мы сообщаем Spring, что в данном классе содержится определение аспекта, но это не значит, что Spring сразу создаст для него бин
 */
@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**@Around Аннотация совета.
     * Вплетает аспект в выбранный метод
     * @param joinPoint
     * @throws Throwable
     */
   @Around("execution(* ru.surovcev.comment.log.service.service.*.*(..))")      // Здесь используется язык срезов AspectJ
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("method will execute");     // выводит сообщение перед выполнение метода
        joinPoint.proceed();                         // Делегирование управления перехваченному методу (вызывает перехваченный метод)
        logger.info("method executed");         // выводит сообщение после выполнения метода
    }
}
