package com.bridgelabz.bankinfo.service;

import com.bridgelabz.bankinfo.dto.BankInfoDto;
import com.bridgelabz.bankinfo.exception.CandidateException;
import com.bridgelabz.bankinfo.model.BankInfo;
import com.bridgelabz.bankinfo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BankService implements IBankService {
    @Autowired
    private BankRepository bankRepository;

    @Override
    public BankInfo addBankDetails(BankInfoDto bankInfoDto) {
        BankInfo bankInfo= new BankInfo(bankInfoDto);
        return bankRepository.save(bankInfo);
    }

    @Override
    public List<BankInfo> getAllBankDetails() {
        List<BankInfo> bankInfoList = bankRepository.findAll();
        if (bankInfoList.isEmpty()){
            throw new CandidateException(HttpStatus.NOT_FOUND,"There are no bank details added yet!!");
        }else
            return bankInfoList;
    }

    @Override
    public BankInfo getById(long id) {
        Optional<BankInfo> bankInfo = bankRepository.findById(id);
        if (bankInfo.isPresent()) {
            return bankInfo.get();
        } else
            throw new CandidateException(HttpStatus.NOT_FOUND, "This Id is not found! ");
    }

    @Override
    public List<BankInfo> getByCandidateId(long id) {
        List <BankInfo> bankInfoList= bankRepository.findByCandidateId(id);
        if(bankInfoList.isEmpty()){
            throw new CandidateException(HttpStatus.NOT_FOUND,"this id is not found! ");
        }else
            return bankInfoList;
    }

    @Override
    public BankInfo updateBankInfo(long id, BankInfoDto bankInfoDto) {
        Optional<BankInfo> bankInfo = bankRepository.findById(id);
        if (bankInfo.isPresent()) {
            BankInfo newBankInfo = new BankInfo(id, bankInfoDto);
            bankRepository.save(newBankInfo);
            return newBankInfo;
        } else {
            throw new CandidateException(HttpStatus.NOT_FOUND, "BankDetails not found by this ID");
        }
    }
    @Override
    public void deleteById(long id) {
        Optional<BankInfo> candidate = bankRepository.findById(id);
        if (candidate.isPresent()) {
            bankRepository.deleteById(id);
        } else {
            throw new CandidateException("Candidate record does not found");
        }
    }
}
