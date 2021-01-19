package model.common;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Diary implements Serializable {



    @Id
    private String id;

    @ManyToOne
    public List<String> diariestext = new ArrayList<>();

    @Column
    private String dailyEntry;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Diary() {
    
    }
    public Diary(String dailyEntry, Date creationDate){
       this.dailyEntry = dailyEntry;
        this.creationDate = new Date(creationDate.getTime());
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDailyEntry() {
		return String.valueOf(dailyEntry);
	}

	public void setDailyEntry(String diariestext) {
		this.dailyEntry = diariestext;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

    public void addEntry(){
        diariestext.add(this.dailyEntry);
    }

   
}

