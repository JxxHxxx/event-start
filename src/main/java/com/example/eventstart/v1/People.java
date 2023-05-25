package com.example.eventstart.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer 들은 말 그대로 Observer이다. 옵저버 패턴에서는 Observer 들은 굉장히 수동적이다.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class People implements Observer {

    private String token;

    @Override
    public void update(Observable o, Object arg) {
        log.info("침착맨이 방송을 시작했어요.");

        if (arg instanceof String) {
           this.token = (String) arg;
            log.info("입장 코드 : {}" , token);
        }
    }

    public String getToken() {
        return this.token;
    }
}
