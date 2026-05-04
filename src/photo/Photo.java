package photo;

import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String fileName;
    private LocalDate date;
    private String location;
    private Set<String> tags;


    public Photo(String id, String fileName, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.fileName = fileName;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }

}