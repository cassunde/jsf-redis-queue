package br.com.cassunde.thymeleaf;

public class Author {

	private String nam;
	private String title;
	public Author(String nam, String title) {
		super();
		this.nam = nam;
		this.title = title;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
