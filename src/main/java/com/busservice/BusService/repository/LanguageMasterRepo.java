package com.busservice.BusService.repository;

import com.busservice.BusService.entity.LanguageMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageMasterRepo extends JpaRepository<LanguageMasterEntity, Integer> {

    public Optional<LanguageMasterEntity> findByLangNameEqualsIgnoreCase(String langName);
}
