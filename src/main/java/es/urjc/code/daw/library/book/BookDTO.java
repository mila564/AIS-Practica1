package es.urjc.code.daw.library.book;

public class BookDTO {
	
	
	private Long id;
	private String title;
	private String description;
	
	public BookDTO() {}

	public BookDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
