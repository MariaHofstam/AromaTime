package se.lexicon.maria.aromatime.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import javax.persistence.JoinColumn;


@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String recipeName;
	
	@Column(name = "ShortDesc")
	private String shortDescription;
	
	private String urlPath;
	
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.LAZY, 
			mappedBy = "recipe",
			orphanRemoval = true
		)
	private Set<RecipeContent> content = new TreeSet<>();
	
	
	@ManyToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.LAZY
		)
	@JoinTable(name= "recipe_categoriy"
			, joinColumns= @JoinColumn(name= "recipe_id")
			, inverseJoinColumns= @JoinColumn(name= "category_id"))
	private List<RecipeCategory> categoryList = new ArrayList<>(); 	//List of categories for this recipe
	
	
	public Recipe(String recipeName, String shortDescription, String urlPath) {
		this.recipeName = recipeName;
		this.shortDescription = shortDescription;
		this.urlPath = urlPath;
	}

	public Recipe() {}

	

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public Set<RecipeContent> getContent() {
		return content;
	}

	public void setContent(Set<RecipeContent> content) {
		this.content = content;
	}

	public List<RecipeCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<RecipeCategory> categoryList) {
		this.categoryList = categoryList;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
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
		Recipe other = (Recipe) obj;
		if (id != other.id)
			return false;
		if (recipeName == null) {
			if (other.recipeName != null)
				return false;
		} else if (!recipeName.equals(other.recipeName))
			return false;
		return true;
	}
	
	
	public boolean addRecipeContent(RecipeContent ingredient) {
		if(ingredient.getRecipe() != null) {
			throw new IllegalArgumentException();
		}
		
		ingredient.setRecipe(this);
		return content.add(ingredient);
	}
	
	public boolean removeRecipeContent(RecipeContent ingredient) {
		if(!content.contains(ingredient)) {
			throw new IllegalArgumentException();
		}
		
		ingredient.setRecipe(null);
		return content.remove(ingredient);
	}
	
	
	public void addCategory(RecipeCategory category) {
		if(!categoryList.contains(category)) {
			categoryList.add(category);
		}
	}
	
	public void removeCategory(RecipeCategory category) {
		if(categoryList.contains(category)) {
			categoryList.remove(category);
		}
	}
	
}
