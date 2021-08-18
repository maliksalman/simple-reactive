package com.smalik.webflux;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FluxController {

    private final FluxService svc;

    public FluxController(FluxService svc) {
        this.svc = svc;
    }

    @GetMapping("/answer/{id}")
    public Mono<String> getAnswer(@PathVariable int id) {
        return svc.getAnswerFor(id)
            .timeout(Duration.ofSeconds(15), Mono.just("** Timeout **"));
    }
    
    @PostMapping("/answer/{id}/{answer}")
    public void registerAnswer(@PathVariable int id, @PathVariable String answer) {
        svc.registerAnswer(id, answer);
    }
}
