package dto;

import java.io.Serializable;
import java.util.Arrays;

public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;
	private String blogTitle;
	private String blogDesc;
	private char[] blogContent;

	private String blogContentForRetrival;
	private String location;

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogDesc() {
		return blogDesc;
	}

	public void setBlogDesc(String blogDesc) {
		this.blogDesc = blogDesc;
	}

	public char[] getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(char[] blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogContentForRetrival() {
		return blogContentForRetrival;
	}

	public void setBlogContentForRetrival(String blogContentForRetrival) {
		this.blogContentForRetrival = blogContentForRetrival;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Blog [blogTitle=" + blogTitle + ", blogDesc=" + blogDesc + ", blogContent="
				+ Arrays.toString(blogContent) + ", blogContentForRetrival=" + blogContentForRetrival + ", location="
				+ location + "]";
	}

}
