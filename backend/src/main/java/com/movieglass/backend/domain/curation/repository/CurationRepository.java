package com.movieglass.backend.domain.curation.repository;

import com.movieglass.backend.domain.curation.entity.Curation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CurationRepository extends JpaRepository<Curation, String> {
    List<Curation> findByDescription(String description);
    List<Curation> findByUserIdAndDescription(String userId, String description);
    Page<Curation> findAll(Pageable pageable);
}
