package blankapp.service;

import java.util.Arrays;
import java.util.List;

public class BlankServiceImpl implements BlankService {
    @Override
    public List<String> read() {
        return Arrays.asList("String1", "String2", "String3");
    }

    @Override
    public void write(List<String> messages) {
        for (String str: messages) {
            System.out.println(str);
        }
    }
}
