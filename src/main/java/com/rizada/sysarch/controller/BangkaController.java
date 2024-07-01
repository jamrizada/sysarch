package com.rizada.sysarch.controller;

import com.rizada.sysarch.model.Bangka;
import com.rizada.sysarch.service.BangkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bangka")
public class BangkaController {

    @Autowired
    private BangkaService bangkaService;

    @GetMapping
    public ResponseEntity<List<Bangka>> getAllBangkas() {
        List<Bangka> bangkas = bangkaService.getAllBangkas();
        return ResponseEntity.ok(bangkas);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Bangka>> searchBangkas(@RequestParam String bangkaName) {
        List<Bangka> bangkas = bangkaService.searchBangkasByBangkaName(bangkaName);
        return ResponseEntity.ok(bangkas);
    }

    @PostMapping
    public ResponseEntity<Bangka> createBangka(@RequestBody Bangka bangka) {
        Bangka savedBangka = bangkaService.saveBangka(bangka);
        return ResponseEntity.ok(savedBangka);
    }
}
