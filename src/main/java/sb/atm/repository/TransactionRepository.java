package sb.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.atm.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}