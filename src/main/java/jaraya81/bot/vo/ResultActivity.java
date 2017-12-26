package jaraya81.bot.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jaraya81.bot.enums.State;

public class ResultActivity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4659884102858090771L;

	private State state;
	private String description;
	private Long time;
	private List<T> listObjects = new ArrayList<T>();
	private T object;

	public ResultActivity() {
		super();
	}

	public ResultActivity(State state, String description, Long time, List<T> listObjects) {
		super();
		this.state = state;
		this.description = description;
		this.time = time;
		this.listObjects = listObjects;
	}

	public void addList(T object) {
		this.listObjects.add(object);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
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

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
}
