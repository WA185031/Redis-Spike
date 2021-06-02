package com.ncr.redisSpike.controllers;

import com.ncr.redisSpike.models.sessionToTeller;
import com.ncr.redisSpike.repository.sessionToTellerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1")
public class SessionToTellerController {

    private sessionToTellerRepository _sessionToTellerRepository;

    public SessionToTellerController(sessionToTellerRepository sessionToTellerRepository){
        _sessionToTellerRepository = sessionToTellerRepository;
    }

    @GetMapping("/all")
    public Map<String, sessionToTeller> GetAll(){
       return _sessionToTellerRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public sessionToTeller GetAll(@PathVariable("id") final String id){
        return _sessionToTellerRepository.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody sessionToTeller sessiontoteller){
        _sessionToTellerRepository.save(new sessionToTeller(sessiontoteller.getSessionId(),sessiontoteller.getTellerId()));
    }




}
