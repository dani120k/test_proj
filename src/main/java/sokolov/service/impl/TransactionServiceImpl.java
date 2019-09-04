package sokolov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sokolov.model.Transaction;
import sokolov.repository.TransactionRepository;
import sokolov.service.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void add(Transaction transaction){
        transactionRepository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction){
        transactionRepository.delete(transaction);
    }

    @Override
    public List<Transaction> findAll(){
        return (List<Transaction>)transactionRepository.findAll();
    }
}
