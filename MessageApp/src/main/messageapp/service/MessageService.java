package messageapp.service;

import java.util.List;

import messageapp.domain.Message;
import messageapp.rules.trigger.TriggerRule;

/**
 * Service to perform Message related operations.
 */
public interface MessageService {

    /**
     * Return a list of Messages from an array of Strings with filePaths for messages.
     *
     * @param messageFiles Array of String with filePaths for messages.
     * @return List of Messages.
     */
    List<Message> read(String[] messageFiles);

    /**
     * Write files based on a list of Messages on the system.
     *
     * @param messages List of Messages to be written on files.
     */
    void write(List<Message> messages);

    /**
     * Perform a set of transformation rules on a list of Messages, based on trigger rules.
     * Generate a transformed list and the messages from the original list are not changed.
     *
     * @param messages List of Messages to be transformed.
     * @param rules    List of Trigger rules that apply transformations to messages, if a certain criteria is met.
     * @return List of transformed Messages.
     */
    List<Message> transform(List<Message> messages, List<TriggerRule> rules);

}
