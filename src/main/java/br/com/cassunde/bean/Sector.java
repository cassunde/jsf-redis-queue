package br.com.cassunde.bean;

public class Sector {

	private String name;
	private String local;	
	
	public Sector(String name, String local) {
		this.name = name;
		this.local = local;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}	
	
	@Override
	public String toString() {
		return name;
	}
}
