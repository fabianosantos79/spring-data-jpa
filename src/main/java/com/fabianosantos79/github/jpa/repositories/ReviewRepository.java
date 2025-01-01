package com.fabianosantos79.github.jpa.repositories;

import com.fabianosantos79.github.jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
