package com.fabianosantos79.github.jpa.repositories;

import com.fabianosantos79.github.jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
