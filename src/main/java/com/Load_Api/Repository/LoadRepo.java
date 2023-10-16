package com.Load_Api.Repository;

import com.Load_Api.Model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadRepo extends JpaRepository<Load,Long> {
    List<Load> findByShipperId(UUID shipperId);
}
