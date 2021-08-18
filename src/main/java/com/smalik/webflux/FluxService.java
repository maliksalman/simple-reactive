package com.smalik.webflux;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@Service
public class FluxService {
    
    private Flux<Pair> pairs;
    private FluxSink<Pair> sink;

    public FluxService() {
        pairs = Flux.create((FluxSink<Pair> s) -> this.sink = s)
            .share();
    }

    public Mono<String> getAnswerFor(int id) {
        return pairs
                .filter(p -> id == p.id)
                .next()
                .map(p -> p.answer);
    }

    public void registerAnswer(int id, String answer) {
        sink.next(new Pair(id, answer));
    }

    static class Pair {
        Pair(int id, String answer) {
            this.id = id;
            this.answer = answer;
        }
        int id;
        String answer;
    }
}