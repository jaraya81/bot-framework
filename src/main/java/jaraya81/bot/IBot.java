package jaraya81.bot;

import jaraya81.bot.vo.Result;

public interface IBot {

	public <T> Result<T> start() throws Exception;

	public <T> Result<T> body() throws Exception;

	public <T> Result<T> end() throws Exception;

}
