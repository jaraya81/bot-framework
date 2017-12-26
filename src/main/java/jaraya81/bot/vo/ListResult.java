package jaraya81.bot.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jaraya81.bot.enums.EnumState;

public class ListResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4659884102858090771L;

	private EnumState state;
	private String description;
	private Long time;
	private List<T> listObjects = new ArrayList<T>();

	public ListResult() {
		super();
	}

	public ListResult(EnumState state, String description, Long time, List<T> listObjects) {
		super();
		this.state = state;
		this.description = description;
		this.time = time;
		this.listObjects = listObjects;
	}

	public void addList(T object) {
		this.listObjects.add(object);
	}

	public EnumState getState() {
		return state;
	}

	public void setState(EnumState state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public List<T> getListObjects() {
		return listObjects;
	}

	public void setListObjects(List<T> listObjects) {
		this.listObjects = listObjects;
	}
}
