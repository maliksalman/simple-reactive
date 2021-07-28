package com.smalik.webflux;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class SimpleController {

    private final String language;
    private final Map<String, String> greetings = Map.of(
        "spanish", "Hola Mundo!",
        "chinese", "Ni Hao, Shijie!",
//        "french", "Bonjour le monde!",
        "english", "Hello World!");

    public SimpleController(@Value("${greeting.language:}") String language) {
        if (greetings.containsKey(language)) {
            this.language = language;
        } else {
            this.language = "english";
        }
    }

    @GetMapping("/language")
    public Mono<String> getLocalLanguage() {
        return Mono.just(language);
    }

    @GetMapping(value = { "/", "/greeting" })
    public Mono<Greeting> getGreeting() {
        return getLocalLanguage()
            .map(lang -> new Greeting(greetings.get(lang)));
    }
}
