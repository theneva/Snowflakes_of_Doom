package no.nith.pj3100_13.snowflakes_of_doom.dto;

public class TextDto {
	
	private String imageUrl;
	
	private String text;
	
	public TextDto() {
		this(null, null);
	}
	
	public TextDto(String imageUrl, String text) {
		setImageUrl(imageUrl);
		setText(text);
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}

}
