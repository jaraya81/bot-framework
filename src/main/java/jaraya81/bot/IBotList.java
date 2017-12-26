package jaraya81.bot;

import jaraya81.bot.vo.ListResult;

public interface IBotList {

	public <T> ListResult<T> start() throws Exception;

	public <T> ListResult<T> body() throws Exception;

	public <T> ListResult<T> end() throws Exception;

}
