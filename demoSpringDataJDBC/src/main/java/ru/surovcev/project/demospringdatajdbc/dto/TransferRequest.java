package ru.surovcev.project.demospringdatajdbc.dto;

import java.math.BigDecimal;

/**
 * Причины вынесения в отдельное DTO (Data Transfer Object):
 * - Специализация для API: DTO точно соответствует формату запроса API и Может отличаться от внутренних моделей приложения
 * - Валидация: Можно добавить аннотации валидации (например, @NotNull, @Positive)
 * - Защита от переполнения: Ограничивает данные, которые можно передать в сервисный слой и предотвращает передачу лишних данных
 * - Стабильность API: Изменения в моделях БД не влияют на API
 * Можно версионировать DTO отдельно от бизнес-моделей
 * - Удобство документирования: Swagger и другие инструменты могут генерировать документацию на основе DTO
 */
public class TransferRequest {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

    public long getSenderAccountId() {return senderAccountId;}
    public void setSenderAccountId(long senderAccountId) {this.senderAccountId = senderAccountId;}

    public long getReceiverAccountId() {return receiverAccountId;}
    public void setReceiverAccountId(long receiverAccountId) {this.receiverAccountId = receiverAccountId;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
}
