package fi.kauhanen.CookBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name, dishType, ingredient, measure;
	private int readyIn, amount;
	
	
	public Recipe() {
	}

	public Recipe(String name, String dishType, String ingredient, String measure, int readyIn, int amount) {
		super();
		this.name = name;
		this.dishType = dishType;
		this.ingredient = ingredient;
		this.measure = measure;
		this.readyIn = readyIn;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public int getReadyIn() {
		return readyIn;
	}

	public void setReadyIn(int readyIn) {
		this.readyIn = readyIn;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
