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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.CoreConstants;

/**
 * A DateParser parses a date field from a string and populates the
 * appropriate field in a given logging event  
 */
public class DateParser implements FieldCapturer<ILoggingEvent> {
  public static final Logger logger = LoggerFactory.getLogger(DateParser.class);
  
  @Override
  public void captureField(ILoggingEvent event, String fieldAsStr, String convPattern) {
    if (fieldAsStr == null || fieldAsStr.isEmpty()) return;
  
    // default to ISO8601 is no conversion pattern given
    if (convPattern == null || convPattern.isEmpty() || convPattern.equals(CoreConstants.ISO8601_STR)) {
      convPattern = CoreConstants.ISO8601_PATTERN;
    }
    
    try {
      DateFormat format = new SimpleDateFormat(convPattern);
      Date date = format.parse(fieldAsStr);
      
      if (event instanceof LoggingEvent) {
        LoggingEvent e = (LoggingEvent)event;
        e.setTimeStamp(date.getTime());
      } else {
        logger.warn("Expected LoggingEvent but saw {}", event.getClass());
      }
    } catch (IllegalArgumentException e) {
      logger.error(e.toString());
    } catch (ParseException e) {
      logger.error(e.toString());
    }
  }

}
