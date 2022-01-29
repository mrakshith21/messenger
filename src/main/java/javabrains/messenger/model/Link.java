package javabrains.messenger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

	public String link;
	public  String rel;
	public Link(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}
	
	
	
}
