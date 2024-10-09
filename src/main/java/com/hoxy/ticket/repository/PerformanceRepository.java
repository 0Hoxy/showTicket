package com.hoxy.ticket.repository;

import com.hoxy.ticket.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    Performance findPerformanceById(Long id);
}
