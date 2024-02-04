package com.example.OAthTest.repository;

import com.example.OAthTest.domain.Member;
import com.example.OAthTest.dto.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByEmail(String email);

}
