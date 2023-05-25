package com.example.eventstart.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.UUID;

/**
 * Observable 을 '해석하면 관찰할 수 있는'이다. 어떠한 Subject를 의미한다.
 * 이 Subject 들은 어떠한 행위를 한다. 그렇게 되면 Subject를 관찰하고 있는 Observer 에게 영향을 줄 수 있다.
 */

@Slf4j
@Service
public class CalmDownMan extends Observable {

    public void broadcast() {
        log.info("방송을 시작합니다.");
        String token = UUID.randomUUID().toString();
        setChanged();
        notifyObservers(token);
    }
}
