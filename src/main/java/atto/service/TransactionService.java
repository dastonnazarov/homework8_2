package atto.service;

import atto.container.ComponentContainer;
import atto.dto.Transaction;
import atto.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionRepository.saveTransaction(transaction);
        } else System.err.println("error!!!!!!!!!!");
    }

    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
