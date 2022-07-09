package com.bridgelabz.bankinfo.repository;

import com.bridgelabz.bankinfo.model.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<BankInfo, Long> {
    List<BankInfo> findByCandidateId(long id);
}
