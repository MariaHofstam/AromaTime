package se.lexicon.maria.aromatime.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class RecipeCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String categoryName;
	
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.LAZY
		)
	@JoinTable(name= "recipe_categoriy"
			, joinColumns= @JoinColumn(name= "category_id")
			, inverseJoinColumns= @JoinColumn(name= "recipe_id"))
	private List<Recipe> recipeList = new ArrayList<>(); 	//List of recipes for this category
	//Because of cascade, recipeList do not need any methods for adding and removing recipes,
	//it is taken cared of in Entry Recipe.
															
	
	
	public RecipeCategory(String categoryName, List<Recipe> recipeList) {
		this.categoryName = categoryName;
		this.recipeList = recipeList;
	}

	protected RecipeCategory() {}
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "RecipeCategory [id=" + id + ", categoryName=" + categoryName + ", recipeList=" + recipeList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeCategory other = (RecipeCategory) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
