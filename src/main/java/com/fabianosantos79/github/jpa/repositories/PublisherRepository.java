package com.fabianosantos79.github.jpa.repositories;

import com.fabianosantos79.github.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
