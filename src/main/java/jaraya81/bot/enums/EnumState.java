package jaraya81.bot.enums;

public enum EnumState {

	OK("OK"), ERROR("ERR");
	private String code;

	private EnumState(String code) {
		this.code = code;
	}

	public String getEstado() {
		return code;
	}

}
