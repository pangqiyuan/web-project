package club.klovec.common.pojo;

import club.klovec.pojo.YhIteams;

public class YhIteamsChild extends YhIteams {
	private String[] images;
	boolean enough;

	public boolean isEnough() {
		return enough;
	}

	public void setEnough(boolean enough) {
		this.enough = enough;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}
	
	
	
}
