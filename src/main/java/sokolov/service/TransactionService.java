package sokolov.service;

import sokolov.model.Transaction;

import java.util.List;

public interface TransactionService {
    void add(Transaction transaction);

    void delete(Transaction transaction);

    List<Transaction> findAll();
}
