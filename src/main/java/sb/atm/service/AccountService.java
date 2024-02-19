package sb.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.atm.model.Account;
import sb.atm.repository.AccountRepository;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @Transactional
    public void transferAmount(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        Account targetAccount = accountRepository.findByAccountNumber(targetAccountNumber)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        transactionService.saveTransaction(sourceAccount, targetAccount, amount);
    }


}