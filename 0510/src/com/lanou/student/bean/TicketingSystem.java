package com.lanou.student.bean;

/**
 * @author WANG
 */
public class TicketingSystem {
	/** 序号 */
	private int id;
	/** 电影 */
	private String movie;
	/** 导演 */
	private String director;
	/** 主演 */
	private String starring;
	/** 类型 */
	private String type;
	/** 地区 */
	private String area;
	/** 语言 */
	private String language;
	/** 上映时间 */
	private String releaseTime;

	public TicketingSystem() {
	}

	public TicketingSystem(int id, String movie, String director, String starring, String type, String area, String language, String releaseTime) {
		this.id = id;
		this.movie = movie;
		this.director = director;
		this.starring = starring;
		this.type = type;
		this.area = area;
		this.language = language;
		this.releaseTime = releaseTime;
	}

	@Override
	public String toString() {
		return "id=" + id +
				"电影：" + movie + '\t' +
				"导演：" + director + '\t' +
				"主演：" + starring + '\t' +
				"类型：" + type + '\t' +
				"地区：" + area + '\t' +
				"语言：" + language + '\t' +
				"上映时间：" + releaseTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStarring() {
		return starring;
	}

	public void setStarring(String starring) {
		this.starring = starring;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
}
