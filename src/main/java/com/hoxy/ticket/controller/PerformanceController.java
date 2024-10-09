package com.hoxy.ticket.controller;

import com.hoxy.ticket.dto.PerformanceDTO;
import com.hoxy.ticket.entity.Performance;
import com.hoxy.ticket.service.PerformanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PerformanceController {

    @Autowired
    private PerformanceService service;
    @Autowired
    private ModelMapper modelMapper;


    //공연 생성
    @PostMapping("/performances")
    public ResponseEntity<Performance> addPerformance(@RequestBody PerformanceDTO dto) {
        Performance show = service.add(dto);
        return ResponseEntity.status(201).body(show);
    }

    //공연 전체 찾기
    @GetMapping("/performances")
    public ResponseEntity<List<PerformanceDTO>> getPerformances() {
        List<PerformanceDTO> shows = service.findAll()
                .stream()
                .map(performance -> modelMapper.map(performance, PerformanceDTO.class))
                .toList();
        return ResponseEntity.ok().body(shows);
    }

    //특정 id 공연 찾기
    @GetMapping("/performances/{id}")
    public ResponseEntity<PerformanceDTO> getPerformanceById(@PathVariable Long id) {
        Performance performance = service.findPerformanceById(id);
        PerformanceDTO performanceDTO = modelMapper.map(performance, PerformanceDTO.class);
        return ResponseEntity.ok().body(performanceDTO);
    }


    @PutMapping("/performances/{id}")
    public ResponseEntity<PerformanceDTO> updatePerformance(@PathVariable Long id, @RequestBody PerformanceDTO dto) {
        Performance performance = service.updatePerformanceById(id, dto);
        PerformanceDTO performanceDTO = modelMapper.map(performance, PerformanceDTO.class);
        return ResponseEntity.ok().body(performanceDTO);
    }

    @DeleteMapping("/performances/{id}")
    public ResponseEntity<PerformanceDTO> deletePerformance(@PathVariable Long id) {
        if(!service.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        service.deletePerformanceById(id);
        return ResponseEntity.noContent().build();
    }
}
