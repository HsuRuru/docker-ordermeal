package com.order.springorder.repository;

import com.order.springorder.datamodel.ERole;
import com.order.springorder.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByName(ERole name);
}