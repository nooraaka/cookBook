package fi.kauhanen.CookBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long recipeid;
	private String recipeName, ingredient, method;

	@ManyToOne
	@JoinColumn(name="dishtypeid")
	private DishType dishType;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
//	private List<Weekday> weekdays;
	
	public Recipe() {
	}

	public Recipe(String recipeName, String ingredient, String method) {
		super();
		this.recipeName = recipeName;
		this.ingredient = ingredient;
		this.method = method;
	}
	
	public Recipe(String recipeName, String ingredient, String method, DishType dishType) {
		super();
		this.recipeName = recipeName;
		this.ingredient = ingredient;
		this.method = method;
		this.dishType = dishType;
	}
	
	public long getRecipeid() {
		return recipeid;
	}
	
	public void setRecipeid(long recipeid) {
		this.recipeid = recipeid;
	}
	
	public String getRecipeName() {
		return recipeName;
	}
	
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Override
	public String toString() {
		return "Recipe [recipeid=" + recipeid + ", recipeName=" + recipeName + ", ingredient=" + ingredient + ", method="
				+ method + ", dishType=" + dishType + "]";
	}

}
