package com.example.eventstart.v2.repository;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    private Map<Long, String> store = new HashMap<>();
    private static Long sequence = 0l;

    public void save(String memberName) {
        store.put(sequence++, memberName);
    }

    public String findOne(Long memberId) {
        return store.get(memberId);
    }
}
