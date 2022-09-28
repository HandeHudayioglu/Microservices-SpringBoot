package com.hande.repository;


import com.hande.repository.entity.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewsRepository extends JpaRepository<Views,Long> {
}
