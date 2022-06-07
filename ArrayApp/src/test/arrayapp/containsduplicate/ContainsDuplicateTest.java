package arrayapp.containsduplicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTest {

    @Test
    void containsDuplicateTest() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1}));
        assertTrue(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
