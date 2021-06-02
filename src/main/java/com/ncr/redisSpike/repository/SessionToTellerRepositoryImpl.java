package com.ncr.redisSpike.repository;


import com.ncr.redisSpike.models.sessionToTeller;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SessionToTellerRepositoryImpl implements sessionToTellerRepository {

    private RedisTemplate<String, sessionToTeller> redisTemplate;
    private HashOperations hashOperations; //to access redis cache

    public SessionToTellerRepositoryImpl(RedisTemplate<String, sessionToTeller> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(sessionToTeller sessionToTellerObj) {
        hashOperations.put("sessionToTeller","ast:tellercontrol:session-teller:"+sessionToTellerObj.getSessionId(),sessionToTellerObj);
    }

    @Override
    public Map<String,sessionToTeller> findAll() {
        return hashOperations.entries("sessionToTeller");
    }

    @Override
    public sessionToTeller findById(String id) {
        return (sessionToTeller)hashOperations.get("session","ast:tellercontrol:session-teller:"+id);
    }

}
