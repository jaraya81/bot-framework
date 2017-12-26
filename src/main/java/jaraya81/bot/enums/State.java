package jaraya81.bot.enums;

public enum State {

	OK("OK"), ERROR("ERR");
	private String code;

	private State(String code) {
		this.code = code;
	}

	public String getEstado() {
		return code;
	}

}
