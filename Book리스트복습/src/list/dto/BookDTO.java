package list.dto;

public class BookDTO {
	
	private String title;
	private String writer;
	private int price;
	
	public BookDTO() {
		
	}
	
	public BookDTO(String title, String writer, int pirce) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = pirce;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int pirce) {
		this.price = pirce;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
	
	
	

}
