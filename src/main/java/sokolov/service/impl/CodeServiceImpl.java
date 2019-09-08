package sokolov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sokolov.model.Code;
import sokolov.repository.CodeRepository;
import sokolov.service.CodeService;

import java.util.List;
import java.util.Optional;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeRepository codeRepository;

    @Override
    public void add(Code code){
        codeRepository.save(code);
    }

    @Override
    public void delete(Code code){
        codeRepository.delete(code);
    }

    @Override
    public List<Code> getAll(){
        return (List<Code>)codeRepository.findAll();
    }

    @Override
    public Optional<Code> findByCode(int code){
        return codeRepository.findOneByPrimCode(code);
    }
}
