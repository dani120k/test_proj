package sokolov.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sokolov.model.Code;
import sokolov.Status;
import sokolov.model.Transaction;
import sokolov.service.impl.CodeServiceImpl;
import sokolov.service.impl.TransactionServiceImpl;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    @Autowired
    private CodeServiceImpl codeServiceImpl;

    @GetMapping("/")
    public void addTransaction(@RequestParam Transaction transaction){
        Optional<Code> code = codeServiceImpl.findByCode(transaction.getCode().getPrimCode());
        if (code.isPresent()) {
            transaction.setCode(code.get());
            transactionService.add(transaction);
        } else {
            Code create_code = new Code();
            create_code.setPrimCode(transaction.getCode().getPrimCode());
            codeServiceImpl.add(create_code);
            transaction.setCode(create_code);
            transactionService.add(transaction);
        }
    }

    @CustomLogging
    @GetMapping("/test")
    public void test(){
        Transaction transaction = new Transaction();
        Code code = new Code();
        code.setPrimCode(10);
        codeServiceImpl.add(code);
        System.out.println("ff");
        transaction.setCode(code);
        transaction.setContract_number(123123);
        transaction.setStatus(Status.ACTIVE);
        transaction.setTime(new Date());
        transactionService.add(transaction);
        System.out.println("tt");
        Transaction tr = new Transaction();
        tr.setCode(code);
        tr.setStatus(Status.FINAL);
        tr.setContract_number(124223);
        tr.setTime(new Date());
        transactionService.add(tr);
    }

    @GetMapping("/getStats")
    public String getStats(@RequestParam int code) throws Exception{
        Optional<Code> codes = codeServiceImpl.findByCode(code);
        if (codes.isPresent()){
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(codes.get().getTransactionList());
        } else {
            return "zero";
        }
    }

    @GetMapping("/getAll")
    public String getAll(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(transactionService.findAll());
        }catch (Exception ex){
            return "";
        }
    }

    @GetMapping("/addNew")
    public void addNew(){
        Code code = new Code();
        code.setPrimCode(11);
        codeServiceImpl.add(code);
        Transaction tr = new Transaction();
        tr.setContract_number(123123);
        tr.setTime(new Date());
        tr.setStatus(Status.ACTIVE);
        tr.setCode(code);
        transactionService.add(tr);
    }
}
