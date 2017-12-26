package jaraya81.bot.enums;

public enum State {

	OK("OK"), ERROR("ERR"), WAITING("WAITING"), QUEUED("QUEUED");
	private String code;

	private State(String code) {
		this.code = code;
	}

	public String getEstado() {
		return code;
	}

}
