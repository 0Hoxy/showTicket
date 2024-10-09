package com.hoxy.ticket.service;

import com.hoxy.ticket.dto.PerformanceDTO;
import com.hoxy.ticket.entity.Performance;
import com.hoxy.ticket.repository.PerformanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Performance add(PerformanceDTO performanceDTO) {
        Performance performance = modelMapper.map(performanceDTO, Performance.class);
        return repository.save(performance);
    }

    public List<Performance> findAll() {
        return repository.findAll();
    }

    public Performance findPerformanceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 공연 정보가 없습니다."));
    }

    public Performance updatePerformanceById(Long id, PerformanceDTO performanceDTO) {
        Performance performance = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 공연 정보가 없습니다."));

        //DTO의 데이터를 엔티티에 적용 (데이터 업데이트 부분)
        performance.setShowName(performanceDTO.getShowName());
        performance.setPlace(performanceDTO.getPlace());
        performance.setRunTime(performanceDTO.getRunTime());
        performance.setStartDay(performanceDTO.getStartDay());
        performance.setEndDay(performanceDTO.getEndDay());
        performance.setPrice(performanceDTO.getPrice());

        return repository.save(performance);
    }

    public void deletePerformanceById(Long id) {
        repository.deleteById(id);
    }

    // ID로 공연 존재 여부 확인
    public boolean existsById(Long id) {
        return repository.existsById(id); // 리포지토리에서 제공하는 메서드를 호출
    }
}
