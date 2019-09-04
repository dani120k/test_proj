package sokolov.service;

import sokolov.model.Code;

import java.util.List;
import java.util.Optional;

public interface CodeService {
    void add(Code code);
    void delete(Code code);
    Optional<Code> findByCode(int code);
    List<Code> getAll();
}
