package messageapp.service;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;
import messageapp.rules.trigger.TriggerRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageServiceImplTest {

    private MessageServiceImpl service;

    private List<Message> messages;
    private List<TriggerRule> rules;

    @BeforeEach
    void setUp() {
        service = new MessageServiceImpl();

        messages = generateTestMessages();
        rules = Arrays.asList(new DummyTriggerRulePrimary(Collections.singletonList(new DummyTransformationRulePrimary())),
                new DummyTriggerRuleSecondary(Collections.singletonList(new DummyTransformationRuleSecondary())));
    }

    @Test
    void shouldNotTransformEmptyListTest() {
        messages = new ArrayList<>();
        service.transform(messages, rules);

        assertTrue(messages.isEmpty());
    }

    @Test
    void transformShouldNotTransformListWhenEmptyRulesTest() {
        rules = new ArrayList<>();
        List<Message> transformedMessages = service.transform(messages, rules);

        assertEquals(messages.size(), transformedMessages.size());
        for (int i = 0; i < messages.size(); i++) {
            assertEquals(messages.get(i), transformedMessages.get(i));
        }
    }

    @Test
    void transformShouldTransformMessagesTest() {
        List<Message> transformedMessages = service.transform(messages, rules);

        assertEquals(messages.size(), transformedMessages.size());
        for (int i = 0; i < messages.size(); i++) {
            assertNotEquals(messages.get(i), transformedMessages.get(i));
        }
    }

    @Test
    void transformShouldOnlyApplyOneTriggerRuleTest() {
        List<Message> transformedMessages = service.transform(messages, rules);

        assertTrue(transformedMessages
                .get(0)
                .getBody()
                .startsWith("This the first message and the secondary rule should not be applied to it: "));
        for (int i = 1; i < messages.size(); i++) {
            assertTrue(transformedMessages.get(i).getBody().startsWith("This body was transformed: "));
        }
    }

    @Test
    void generateNewFilePathTest() {
        String originalFilePath = "path/to/the/original/file/file.ext";

        String newFilePath = service.generateNewFilePath(originalFilePath);

        assertEquals("path/to/the/original/file/file_TRANSFORMED.ext", newFilePath);
    }

    private List<Message> generateTestMessages() {
        List<Message> dummyMessages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dummyMessages.add(new Message("Path" + i, "TO", "FROM", "SUBJECT", "BODY" + i));
        }
        return dummyMessages;
    }

    private static class DummyTriggerRulePrimary extends TriggerRule {
        public DummyTriggerRulePrimary(List<TransformationRule> rules) {
            super(rules);
        }

        @Override
        protected boolean verify(Message message) {
            return !message.getBody().isEmpty() && "BODY0".equals(message.getBody());
        }
    }

    private static class DummyTransformationRulePrimary implements TransformationRule {
        @Override
        public void transform(Message message) {
            message.setBody("This the first message and the secondary rule should not be applied to it: " + message.getBody());
        }
    }

    private static class DummyTriggerRuleSecondary extends TriggerRule {
        public DummyTriggerRuleSecondary(List<TransformationRule> rules) {
            super(rules);
        }

        @Override
        protected boolean verify(Message message) {
            return !message.getBody().isEmpty();
        }
    }

    private static class DummyTransformationRuleSecondary implements TransformationRule {
        @Override
        public void transform(Message message) {
            message.setBody("This body was transformed: " + message.getBody());
        }
    }
}
