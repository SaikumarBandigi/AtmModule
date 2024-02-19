package sb.atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sb.atm.model.Account;
import sb.atm.repository.AccountRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class AtmModuleApplication implements CommandLineRunner {


    @Autowired
    private AccountRepository accountRepository;


    public static void main(String[] args) {
        SpringApplication.run(AtmModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Account account1 = new Account();
        account1.setAccountNumber("101");
        account1.setBalance(new BigDecimal(5000));

        accountRepository.save(account1);



        Account account2 = new Account();
        account2.setAccountNumber("102");
        account2.setBalance(new BigDecimal(9000));

        accountRepository.save(account2);
    }



}
