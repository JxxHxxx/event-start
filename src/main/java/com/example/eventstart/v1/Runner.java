package com.example.eventstart.v1;


import lombok.extern.slf4j.Slf4j;

/**
 * 옵저버 패턴은 Subject - Observer 구조이다.
 * 현실 세계와 비유하면 굉장히 이질적이다. 일반적으로 현실 세계에서는 Observer 들이 Subject를 정한다.
 * 우리(Observer)가 유튜브를 볼 때 재밋는 유튜버(Subject)들을 골라서 구독하는 것과 비슷하다.
 *
 * 하지만 옵저버 패턴에서는 주체(Subject)가 옵저를 등록한다.(addObserver)
 */

@Slf4j
public class Runner {

    public static void main(String[] args) {
        CalmDownMan calmDownMan = new CalmDownMan();

        People people1 = new People(); // 구독자
        People people2 = new People(); // 구독자

        calmDownMan.addObserver(people1); // 발행자
        calmDownMan.addObserver(people2);

        calmDownMan.broadcast(); // 발행자가 행위를 한다.
    }
}
