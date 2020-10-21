package fi.kauhanen.CookBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Weekday {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String weekday;
	
//	@ManyToOne
//	@JoinColumn(name="recipeid")
//	private Recipe recipe;

		
}
