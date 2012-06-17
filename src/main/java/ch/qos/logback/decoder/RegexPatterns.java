/**
 * Copyright (C) 2012, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.decoder;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import ch.qos.logback.classic.spi.CallerData;

import java.util.regex.Pattern;

/**
 * Constant regular-expression patterns 
 * 
 * @author Anthony Trinh
 */
public abstract class RegexPatterns {
  abstract class Common {
    public static final String ANYTHING_REGEX = ".+";
    public static final String NON_WHITESPACE_REGEX = "[\\S]+";
    public static final String ANYTHING_MULTILINE_REGEX = "(?s).+";
    public static final String CSV_EQUALITIES_REGEX = "(?:[^=]+=.+,\\s*)*[^=]+=.+";
    
    public static final String IDENTIFIER_REGEX = "[$_a-zA-z0-9]+";
    public static final String FILENAME_REGEX = IDENTIFIER_REGEX + "\\.java";
    
    public static final String INTEGER_REGEX = "\\d+";
    public static final String STACKTRACE_REGEX = "(?s).+(?:Exception|Error)[^\\n]++(?:\\s+at .++)+";
    public static final String DATE_ISO8601_REGEX = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}";
  }
  
  public static final String CALLER_STACKTRACE_REGEX = "(?s)(?:" + Pattern.quote(CallerDataConverter.DEFAULT_CALLER_LINE_PREFIX) + "\\d+\\s+at.*)|(?:"+ Pattern.quote(CallerData.CALLER_DATA_NA) +")";
  public static final String CLASS_OF_CALLER_REGEX = Common.IDENTIFIER_REGEX + "|" + Pattern.quote(CallerData.NA);
  public static final String CONTEXT_NAME_REGEX = Common.NON_WHITESPACE_REGEX;
  public static final String FILE_OF_CALLER_REGEX = Common.FILENAME_REGEX;
  public static final String LEVEL_REGEX = "OFF|WARN|ERROR|INFO|DEBUG|TRACE|ALL";
  public static final String LINE_OF_CALLER_REGEX = Common.INTEGER_REGEX + "|\\?";
  public static final String LOGGER_NAME_REGEX = Common.ANYTHING_REGEX;
  public static final String MARKER_REGEX = Common.ANYTHING_REGEX;
  public static final String MDC_REGEX = Common.CSV_EQUALITIES_REGEX;
  public static final String METHOD_OF_CALLER_REGEX = Common.IDENTIFIER_REGEX;
  public static final String MESSAGE_REGEX = Common.ANYTHING_MULTILINE_REGEX;
  public static final String LINE_SEPARATOR_REGEX = "\\r?\\n";
  public static final String PROPERTY_REGEX = "Property_HAS_NO_KEY" + "|" + Common.NON_WHITESPACE_REGEX;
  public static final String RELATIVE_TIME_REGEX = Common.INTEGER_REGEX;
  public static final String THREAD_NAME_REGEX = Common.NON_WHITESPACE_REGEX;
  public static final String EXCEPTION_REGEX = Common.STACKTRACE_REGEX;
  public static final String ROOT_1ST_EXCEPTION_REGEX = Common.STACKTRACE_REGEX;
  
  public static final Pattern CALLER_STACKTRACE_PATTERN = Pattern.compile(CALLER_STACKTRACE_REGEX);
  public static final Pattern CLASS_OF_CALLER_PATTERN = Pattern.compile(CALLER_STACKTRACE_REGEX);
  public static final Pattern CONTEXT_NAME_PATTERN = Pattern.compile(CONTEXT_NAME_REGEX);
  public static final Pattern FILE_OF_CALLER_PATTERN = Pattern.compile(FILE_OF_CALLER_REGEX);
  public static final Pattern LEVEL_PATTERN = Pattern.compile(LEVEL_REGEX);
  public static final Pattern LINE_OF_CALLER_PATTERN = Pattern.compile(LINE_OF_CALLER_REGEX);
  public static final Pattern LOGGER_NAME_PATTERN = Pattern.compile(LOGGER_NAME_REGEX);
  public static final Pattern MARKER_PATTERN = Pattern.compile(MARKER_REGEX);
  public static final Pattern MDC_PATTERN = Pattern.compile(MDC_REGEX);
  public static final Pattern METHOD_OF_CALLER_PATTERN = Pattern.compile(METHOD_OF_CALLER_REGEX);
  public static final Pattern MESSAGE_PATTERN = Pattern.compile(MESSAGE_REGEX);
  public static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile(LINE_SEPARATOR_REGEX);
  public static final Pattern PROPERTY_PATTERN = Pattern.compile(PROPERTY_REGEX);
  public static final Pattern RELATIVE_TIME_PATTERN = Pattern.compile(RELATIVE_TIME_REGEX);
  public static final Pattern THREAD_NAME_PATTERN = Pattern.compile(THREAD_NAME_REGEX);
  public static final Pattern EXCEPTION_PATTERN = Pattern.compile(EXCEPTION_REGEX);
  public static final Pattern ROOT_1ST_EXCEPTION_PATTERN = Pattern.compile(ROOT_1ST_EXCEPTION_REGEX);
}
