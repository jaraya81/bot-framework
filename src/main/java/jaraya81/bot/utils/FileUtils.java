package jaraya81.bot.utils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public static File getFile(String filePath) throws Exception {
		if (filePath != null && !filePath.isEmpty()) {
			logger.info("getFile:" + filePath);
			return new File(filePath);
		} else {
			throw new Exception("filePath IS NULL OR EMPTY");
		}
	}

	public static Double textToDouble(String text, String pattern) {
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
