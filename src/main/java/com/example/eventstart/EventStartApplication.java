package com.example.eventstart;

import com.example.eventstart.v2.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventStartApplication.class, args);

        MemberRepository memberRepository = new MemberRepository();
        memberRepository.save("유니");
        memberRepository.save("허니");
    }

}
