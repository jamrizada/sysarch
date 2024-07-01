package com.rizada.sysarch.service;

import com.rizada.sysarch.model.Bangka;
import com.rizada.sysarch.repository.BangkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangkaService {

    @Autowired
    private BangkaRepository bangkaRepository;

    public List<Bangka> getAllBangkas() {
        return bangkaRepository.findAll();
    }

    public List<Bangka> searchBangkasByBangkaName(String bangkaName) {
        return bangkaRepository.findByBangkaNameContainingIgnoreCase(bangkaName);
    }

    public Bangka saveBangka(Bangka bangka) {
        return bangkaRepository.save(bangka);
    }
}
