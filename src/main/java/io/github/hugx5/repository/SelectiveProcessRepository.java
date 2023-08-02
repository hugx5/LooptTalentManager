package io.github.hugx5.repository;

import io.github.hugx5.entity.SelectiveProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SelectiveProcessRepository extends JpaRepository<SelectiveProcess, UUID> {

}
