package jaraya81.bot;

import jaraya81.bot.exception.BotException;
import jaraya81.bot.vo.ResultActivity;
import jaraya81.bot.vo.ResultBot;

public interface IBot {

	<T> ResultBot<T> flowRun() throws BotException;

	<T> ResultActivity<T> start() throws BotException;

	<T> ResultActivity<T> end() throws BotException;

}
