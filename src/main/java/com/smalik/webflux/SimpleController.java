package com.smalik.webflux;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SimpleController {

    private String language;

    public SimpleController(@Value("${greeting.language:english}") String language) {
        this.language = language;
    }

    @GetMapping("/language")
    public Mono<String> getLocalLanguage() {
        return Mono.just(language);
    }

    @GetMapping("/greeting")
    public Mono<Greeting> getGreeting() {
        String s = getLocalLanguage().block();
        switch (s) {
            case "spanish":
                return Mono.just(new Greeting("Hola Mundo!"));

            case "chinese":
                return Mono.just(new Greeting("Ni hao, shijie"));

            case "english":
            default:
                return Mono.just(new Greeting("Hello World!"));
        }
    }
}
