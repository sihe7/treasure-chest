package com.hmh.utils;

import java.util.UUID;

public class TraceLogIdUtil {
    private String traceLogId;
    public TraceLogIdUtil() {
    }

    public static String createTraceLogId() {
        return UUID.randomUUID().toString();
    }
    public String getOrGenerateLogId1() {
        if (null == traceLogId || "".equals(traceLogId)) {
            traceLogId = UUID.randomUUID().toString();
        }
        return traceLogId;
    }
    public static String getOrGenerateLogId() {
        return UUID.randomUUID().toString();
    }
}