package messageapp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import messageapp.domain.Message;
import messageapp.domain.MessageField;
import messageapp.rules.trigger.TriggerRule;
import org.jetbrains.annotations.VisibleForTesting;

/**
 * Service to perform Message related operations.
 */
public class MessageServiceImpl implements MessageService {

    private static final String TRANSFORMED_SUFFIX = "_TRANSFORMED";
    private static final String LS = System.lineSeparator();

    public List<Message> read(String[] messageFiles) {
        return Arrays.stream(messageFiles)
                .map(this::read)
                .toList();
    }

    public void write(List<Message> messages) {
        for (Message message : messages)
            writeNewMessageFile(message, generateNewFilePath(message.getFilePath()));
    }

    public List<Message> transform(List<Message> messages, List<TriggerRule> rules) {
        List<Message> transformedMessages = new ArrayList<>();
        for (Message originalMessage : messages) {
            Message transformedMessage = new Message(originalMessage);
            applyRulesToMessage(rules, transformedMessage);
            transformedMessages.add(transformedMessage);
        }

        return transformedMessages;
    }

    /**
     * Return a message from a Message on a file.
     *
     * @param messagePath Filepath for a message.
     * @return an object of Message.
     */
    private Message read(String messagePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(messagePath))) {
            return readMessageFromBufferedReader(br, messagePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read file: " + messagePath);
        }
    }

    private Message readMessageFromBufferedReader(BufferedReader br, String messagePath) throws IOException {
        Message message = new Message();
        message.setFilePath(messagePath);

        String currLine;
        while ((currLine = br.readLine()) != null)
            if (currLine.startsWith(MessageField.TO.getPrefix()))
                message.setTo(currLine.substring(MessageField.TO.getPrefix().length()));
            else if (currLine.startsWith(MessageField.FROM.getPrefix()))
                message.setFrom(currLine.substring(MessageField.FROM.getPrefix().length()));
            else if (currLine.startsWith(MessageField.SUBJECT.getPrefix()))
                message.setSubject(currLine.substring(MessageField.SUBJECT.getPrefix().length()));
            else if (currLine.startsWith(MessageField.BODY.getPrefix()))
                while ((currLine = br.readLine()) != null)
                    message.appendBody(currLine + LS);

        return message;
    }

    @VisibleForTesting
    protected String generateNewFilePath(String messageFilePath) {
        String file = messageFilePath.substring(0, messageFilePath.lastIndexOf("."));
        String fileExtension = messageFilePath.substring(messageFilePath.lastIndexOf("."));
        return file + TRANSFORMED_SUFFIX + fileExtension;
    }

    private void writeNewMessageFile(Message message, String newFilePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath))) {
            writeMessageToBufferedWriter(message, bw);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not write file at: " + newFilePath);
        }
    }

    private void writeMessageToBufferedWriter(Message message, BufferedWriter bw) throws IOException {
        bw.write(MessageField.TO.getPrefix() + message.getTo() + LS);
        bw.write(MessageField.FROM.getPrefix() + message.getFrom() + LS);
        bw.write(MessageField.SUBJECT.getPrefix() + message.getSubject() + LS);
        bw.write(MessageField.BODY.getPrefix() + LS);
        bw.write(message.getBody());
    }

    private void applyRulesToMessage(List<TriggerRule> rules, Message message) {
        for (TriggerRule rule : rules)
            if (rule.apply(message))
                break;
    }

}
