package bookapp.domain;

public class Document {

    private final String name;
    private final String description;
    private final String createdBy;
    private final String lastModifiedBy;
    private final Long sizeInBytes;
    private final Long createdTime;
    private final Long modifiedTime;

    public Document(String name, String description, String createdBy, String lastModifiedBy, Long sizeInBytes, Long createdTime, Long modifiedTime) {
        super();
        this.name = name != null ? name : "";
        this.description = description != null ? description : "";
        this.createdBy = createdBy != null ? createdBy : "";
        this.lastModifiedBy = lastModifiedBy != null ? lastModifiedBy : "";
        this.sizeInBytes = sizeInBytes != null ? sizeInBytes : 0L;
        this.createdTime = createdTime != null ? createdTime : 0L;
        this.modifiedTime = modifiedTime != null ? modifiedTime : 0L;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Long getSizeInBytes() {
        return sizeInBytes;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public Long getModifiedTime() {
        return modifiedTime;
    }

}