package sb.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.atm.model.Account;
import sb.atm.model.Transaction;
import sb.atm.repository.TransactionRepository;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveTransaction(Account sourceAccount, Account targetAccount, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setAmount(amount);

        transactionRepository.save(transaction);
    }
}
