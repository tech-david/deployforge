package com.forge.PortfolioReviewService.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "About_Me_Table")
@EqualsAndHashCode(exclude = {"portfolio", "aboutMeItems"})
@Generated()
public class AboutMe {
	
	@Id
	@Column(name = "about_me_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "description")
	private String description;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id")
	@JsonBackReference(value="portfolio")
    private Portfolio portfolio;
	
//	@ManyToOne
//	@JoinColumn(name="portfolio_id", nullable=false)
//	@JsonBackReference(value="aboutMePortfolio")
//	private Portfolio portfolio;
	
	@OneToMany(mappedBy = "aboutMe",  cascade = CascadeType.ALL)
	@JsonManagedReference(value="aboutMePortfolio")
	private Set<AboutMeItem> aboutMeItems;
	
	@Override
	public String toString() {
		return "AboutMe [id=" + id + ", description=" + description + ", aboutMeItems=" + aboutMeItems + "]";
	}
}
