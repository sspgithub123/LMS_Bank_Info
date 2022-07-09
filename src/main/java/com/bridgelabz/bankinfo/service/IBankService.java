package com.bridgelabz.bankinfo.service;

import com.bridgelabz.bankinfo.dto.BankInfoDto;
import com.bridgelabz.bankinfo.model.BankInfo;

import java.util.List;

public interface IBankService {
    BankInfo addBankDetails(BankInfoDto bankInfoDto);
    List<BankInfo> getAllBankDetails();
    BankInfo getById(long id);
    List<BankInfo> getByCandidateId(long id);
    BankInfo updateBankInfo(long id, BankInfoDto bankInfoDto);
    void deleteById(long id);
}
