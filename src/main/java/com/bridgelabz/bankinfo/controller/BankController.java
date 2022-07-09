package com.bridgelabz.bankinfo.controller;

import com.bridgelabz.bankinfo.dto.BankInfoDto;
import com.bridgelabz.bankinfo.dto.ResponseDTO;
import com.bridgelabz.bankinfo.model.BankInfo;
import com.bridgelabz.bankinfo.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bankInfo")
public class BankController {
    @Autowired
    private IBankService iBankService;

    @PostMapping("/addData")
    public ResponseEntity<ResponseDTO> insertBankDetails(@Valid @RequestBody BankInfoDto bankInfoDto) {
        BankInfo bankInfo = iBankService.addBankDetails(bankInfoDto);
        ResponseDTO response = new ResponseDTO(" BankDetails Added Successfully !!!", bankInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllBankDetails")
    public ResponseEntity<String> getAll() {
        List<BankInfo> listOfBankDetails = iBankService.getAllBankDetails();
        ResponseDTO dto = new ResponseDTO("BankDetails retrieved successfully (:", listOfBankDetails);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/get/{bankID}")
    ResponseEntity<ResponseDTO> getById(@PathVariable long bankID) {
        BankInfo bankInfo = iBankService.getById(bankID);
        ResponseDTO response = new ResponseDTO("Candidate Id found", bankInfo);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/getByBankId/{bankId}")
    ResponseEntity<String> getByCandidate(@PathVariable long bankId) {
        List<BankInfo> bankInfoList= iBankService.getByCandidateId(bankId);
        ResponseDTO dto = new ResponseDTO("Candidate Bankifo retrieved successfully (:", bankInfoList);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @PutMapping("/updateBy/{id}")
    public ResponseEntity<String> updateRecordById(@PathVariable long id, @Valid @RequestBody BankInfoDto bankInfoDto) {
        BankInfo updateRecord = iBankService.updateBankInfo(id, bankInfoDto);
        ResponseDTO dto = new ResponseDTO(" Bankdetails Record updated successfully by Id", updateRecord);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable long id) {
        iBankService.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO("candidate data deleted successfully", id);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
