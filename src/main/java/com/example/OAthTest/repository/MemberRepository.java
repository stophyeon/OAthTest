package com.example.OAthTest.repository;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.dto.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public Optional<Member> findByEmail(String email);

}
