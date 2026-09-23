package com.miguelsouza.encurtadorurl.repository;

import com.miguelsouza.encurtadorurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);
}
