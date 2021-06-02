package com.ncr.redisSpike.models;

import java.io.Serializable;

public class sessionToTeller implements Serializable {
    private String sessionId;
    private String tellerId;

    public sessionToTeller(String sessionId, String tellerId) {
        this.sessionId = sessionId;
        this.tellerId = tellerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTellerId() {
        return tellerId;
    }

    public void setTellerId(String tellerId) {
        this.tellerId = tellerId;
    }
}
