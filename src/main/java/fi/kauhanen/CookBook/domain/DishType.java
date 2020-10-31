package fi.kauhanen.CookBook.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DishType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long dishTypeid;
	private String dishTypeName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dishType")
	private List<Recipe> recipes;
	
	public DishType() {
	}

	public DishType(String dishTypeName) {
		super();
		this.dishTypeName = dishTypeName;
	}

	public DishType(String dishTypeName, List<Recipe> recipes) {
		super();
		this.dishTypeName = dishTypeName;
		this.recipes = recipes;
	}

	public long getDishTypeid() {
		return dishTypeid;
	}

	public void setDishTypeid(long dishTypeid) {
		this.dishTypeid = dishTypeid;
	}

	public String getDishTypeName() {
		return dishTypeName;
	}

	public void setDishTypeName(String dishTypeName) {
		this.dishTypeName = dishTypeName;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "DishType [dishTypeid=" + dishTypeid + ", dishTypeName=" + dishTypeName + ", recipes=" + recipes + "]";
	}

}