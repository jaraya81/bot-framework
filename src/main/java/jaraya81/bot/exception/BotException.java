package jaraya81.bot.exception;

import jaraya81.bot.enums.ErrorCode;

public class BotException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 546636610930042196L;

	private String message;
	private String code;
	private Throwable e;

	public BotException(String message, ErrorCode errorCode) {
		super();
		this.message = message;
		this.code = errorCode.getCode();
	}

	public BotException(String message, ErrorCode errorCode, Throwable e) {
		super();
		this.message = message;
		this.code = errorCode.getCode();
		this.e = e;
	}

}
