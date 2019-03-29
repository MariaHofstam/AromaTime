package se.lexicon.maria.aromatime.entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Name")
	private String recipeName;
	
	@Column(name = "Desc")
	private String shortDescription;
	
	@Column(name = "URL")
	private String urlPath;
	
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.EAGER, 
			mappedBy = "recipe",
			orphanRemoval = true
		)
	private Set<RecipeContent> content = new TreeSet<>();
	
	
	@ManyToMany
	private List<RecipeCategory> categoryList; 	//List of categories for this recipe
	
	
	public Recipe(String recipeName, String shortDescription, String urlPath) {
		super();
		this.recipeName = recipeName;
		this.shortDescription = shortDescription;
		this.urlPath = urlPath;
	}

	protected Recipe() {}

	

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
	
//	public boolean addOrderItem(OrderItem item) {
//		if(item.getOrder() != null) {
//			throw new IllegalArgumentException();
//		}
//		
//		item.setOrder(this);		
//		return content.add(item);
//				
//	}
//	
//	public boolean removeOrderItem(OrderItem item) {
//		if(!content.contains(item)) {
//			throw new IllegalArgumentException();
//		}
//		
//		item.setOrder(null);
//		return content.remove(item);
//	}
	
}
