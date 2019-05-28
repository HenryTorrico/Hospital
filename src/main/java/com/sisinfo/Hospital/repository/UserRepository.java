package com.sisinfo.Hospital.repository;

import com.sisinfo.Hospital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
}
