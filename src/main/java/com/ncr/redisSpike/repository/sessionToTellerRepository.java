package com.ncr.redisSpike.repository;

import com.ncr.redisSpike.models.sessionToTeller;
import java.util.Map;

public interface sessionToTellerRepository {

    void save(sessionToTeller sessionToTellerObj);

    Map<String,sessionToTeller> findAll();

    sessionToTeller findById(String id);
}
