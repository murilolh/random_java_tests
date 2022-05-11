package blankapp.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class BlankServiceImplTest {

    private BlankService service;

    @Before
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
