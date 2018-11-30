package com.zgtong.web.common.logger;

import lombok.Data;


@Data
public class LoggerInfo {
	private boolean request;
	private boolean response;
	private boolean usedtime;
	private boolean shencePoint;
	private String method;
	private String facade;
	private LogFormat requestFormat;
	private LogFormat responseFormat;
	private LogLevel level;
	private boolean onlyFailed;

	public static LoggerInfo defaultLoggerInfo() {
		LoggerInfo loggerInfo = new LoggerInfo();
		loggerInfo.request = true;
		loggerInfo.response = true;
		loggerInfo.shencePoint = false;
		loggerInfo.requestFormat = LogFormat.json;
		loggerInfo.responseFormat = LogFormat.json;
		return loggerInfo;
	}
}
