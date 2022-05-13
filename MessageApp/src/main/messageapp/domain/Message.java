package messageapp.domain;

import java.util.Objects;

/**
 * Class that store a message.
 */
public class Message {

    private String filePath;
    private String to;
    private String from;
    private String subject;
    private String body;

    public Message() {
        this("", "", "", "", "");
    }

    public Message(Message sourceMessage) {
        this(sourceMessage.getFilePath(),
                sourceMessage.getTo(),
                sourceMessage.getFrom(),
                sourceMessage.getSubject(),
                sourceMessage.getBody());
    }

    public Message(String filePath, String to, String from, String subject, String body) {
        super();
        this.filePath = filePath != null ? filePath : "";
        this.to = to != null ? to : "";
        this.from = from != null ? from : "";
        this.subject = subject != null ? subject : "";
        this.body = body != null ? body : "";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void appendBody(String body) {
        this.body = this.body + body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(filePath, message.filePath)
                && Objects.equals(to, message.to)
                && Objects.equals(from, message.from)
                && Objects.equals(subject, message.subject)
                && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, to, from, subject, body);
    }
}