package jaraya81.bot.vo;

import java.io.Serializable;

import jaraya81.bot.enums.State;

public class Result<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2636562495583630849L;

	private State state;
	private String description;
	private Long time;
	private T object;

	public Result() {
		super();
	}

	public Result(State state, String description, Long time, T object) {
		super();
		this.state = state;
		this.description = description;
		this.time = time;
		this.object = object;
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

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
