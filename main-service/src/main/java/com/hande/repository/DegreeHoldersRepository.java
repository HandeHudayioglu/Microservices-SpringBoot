package com.hande.repository;

import com.hande.repository.entity.DegreeHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeHoldersRepository extends JpaRepository<DegreeHolders,Long> {
}
