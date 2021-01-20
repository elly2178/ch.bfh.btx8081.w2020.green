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
    public String diariestext;

    @Column
    private String dailyEntry;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate creationDate;

    public Diary() {
    
    }
    public Diary(String dailyEntry, LocalDate creationDate, String id, String diariestext){
       this.dailyEntry = dailyEntry;
       this.creationDate = creationDate.now();
       this.id = id;
       this.diariestext = diariestext;
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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate.now();
	}
	

    //public void addEntry(){     
      //  diariestext.add(this.dailyEntry);
    //}

   
}

