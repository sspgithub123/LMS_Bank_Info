package com.bridgelabz.bankinfo.model;

import com.bridgelabz.bankinfo.dto.BankInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "bank_info")
public @Data class BankInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String bankName;
    public String bankAccountNumber;
    public String bankBranch;
    public String ifscCode;

    public long candidateId;

    public BankInfo() {
        super();
    }

    public BankInfo(BankInfoDto bankInfoDto) {
        this.bankName = bankInfoDto.getBankName();
        this.bankAccountNumber = bankInfoDto.getBankAccountNumber();
        this.bankBranch = bankInfoDto.getBankBranch();
        this.ifscCode = bankInfoDto.getIfscCode();
        this.candidateId=bankInfoDto.getCandidateId();
    }

    public BankInfo(long id, BankInfoDto bankInfoDto) {
        this.id = id;
        this.bankName = bankInfoDto.getBankName();
        this.bankAccountNumber = bankInfoDto.getBankAccountNumber();
        this.bankBranch = bankInfoDto.getBankBranch();
        this.ifscCode = bankInfoDto.getIfscCode();
        this.candidateId=bankInfoDto.getCandidateId();
    }
}
