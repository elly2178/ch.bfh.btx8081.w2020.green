package model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "diaries")
public class Diary {

    @Id
    private String id;

    @ManyToOne
    public List<String> diariestext = new ArrayList<>();

    @Column(name = "entries")
    private String dailyEntry;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Diary(){
    }

    public Diary(String dailyEntry, Date creationDate){
        this.dailyEntry = dailyEntry;
        this.creationDate = new Date(creationDate.getTime());
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getDailyEntry() {
        return dailyEntry;
    }

    public void setDailyEntry(String dailyEntry) {
        this.dailyEntry = dailyEntry;
    }

    public void addEntry(){
        diariestext.add(this.dailyEntry);
    }
}
