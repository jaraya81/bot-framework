package jaraya81.bot.utils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jaraya81.bot.enums.ErrorCode;
import jaraya81.bot.exception.BotException;

public class FileUtils {
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public static File getFile(String filePath) throws BotException {
		if (filePath != null && !filePath.isEmpty()) {
			logger.info("getFile:" + filePath);
			return new File(filePath);
		} else {
			throw new BotException("filePath IS NULL OR EMPTY", ErrorCode.ERROR);
		}
	}

	public static Double textToDouble(String text, String pattern) throws BotException {
		if (text == null || pattern == null) {
			throw new BotException("params empty", ErrorCode.ERROR);
		}
		Matcher m = Pattern.compile(pattern).matcher(text);
		if (m.find()) {
			String valueSt = m.group();
			logger.info(valueSt);
			return Double.valueOf(valueSt.replaceAll(",", ""));
		} else {
			return null;
		}

	}
}
