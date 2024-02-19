package sb.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sb.atm.service.AccountService;
import sb.atm.service.TransactionService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/atm")
public class ATMController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmount(@RequestParam String sourceAccountNumber,
                                                 @RequestParam String targetAccountNumber,
                                                 @RequestParam BigDecimal amount) {
        accountService.transferAmount(sourceAccountNumber, targetAccountNumber, amount);
        return ResponseEntity.ok("Transfer successful");
    }


}
