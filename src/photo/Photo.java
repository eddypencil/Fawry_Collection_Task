package photo;

import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String fileName;
    private LocalDate date;
    private String location;
    private Set<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Photo(String id, String fileName, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.fileName = fileName;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }

}