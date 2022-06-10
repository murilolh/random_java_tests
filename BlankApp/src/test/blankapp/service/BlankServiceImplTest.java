package blankapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlankServiceImplTest {

    private BlankService service;

    @BeforeEach
    public void setUp() {
        service = new BlankServiceImpl();
    }

    @Test
    public void readTest() {
        List<String> messages = service.read();

        assertEquals(3, messages.size());
        assertEquals("String1", messages.get(0));
        assertEquals("String2", messages.get(1));
        assertEquals("String3", messages.get(2));
    }

    @Test
    public void writeDummyTest() {
        service.write(Collections.singletonList("String1"));
    }
}
