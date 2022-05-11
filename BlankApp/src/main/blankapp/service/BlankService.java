package blankapp.service;

import java.util.List;

public interface BlankService {

    List<String> read();

    void write(List<String> messages);
}
