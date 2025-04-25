package ru.surovcev.project.springboot.service.demofeignclient.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.surovcev.project.springboot.service.demofeignclient.model.Payment;

/**
 * Примечание: никогда не вписывать URI в код
 * Всегда хранить только в файлах свойств (или конфигураций)
 */
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {
    @PostMapping("/payment")
    Payment createPayment (
            @RequestHeader String id,
            @RequestBody Payment payment);
}
