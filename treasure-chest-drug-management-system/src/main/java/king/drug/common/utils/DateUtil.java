package king.drug.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 时间工具类
 * @author: hemenghao
 * @date: 2022/3/23 15:05
 */
@Slf4j
public class DateUtil {
    private DateUtil() {}

    /**
     * 时间格式：HHmmss
     */
    public static final String TIME_PATTERN = "HHmmss";

    /**
     * 时间格式：yyyy/MM/ddHH:mm:ss
     */
    public static final String TIMES_PATTERN = "yyyy/MM/ddHH:mm:ss";

    /**
     * 日期格式：yyyyMMdd
     */
    public static final String DATE_PATTERN = "yyyyMMdd";
    /**
     * 日期格式：yyMMdd
     */
    public static final String SHORT_DATE_PATTERN = "yyMMdd";

    /**
     * 日期格式：yyyy
     */
    public static final String YEAR_PATTERN = "yyyy";

    /**
     * 日期格式：yyyy
     */
    public static final String MONTH_PATTERN = "yyyyMM";

    /**
     * 日期时间格式：yyyyMMddHHmmss
     */
    public static final String FULL_PATTERN = "yyyyMMddHHmmss";

    /**
     * 日期时间格式：yyyyMMddHHmmssSS
     */
    public static final String FULL_PATTERNS = "yyyyMMddHHmmssSS";

    /**
     * 日期时间格式：yyyyMMddHHmmssSSS
     */
    public static final String MILLIS_PATTERNS = "yyyyMMddHHmmssSSS";

    /**
     * 日期时间格式：yyMMddHHmmss
     */
    public static final String PART_PATTERN = "yyMMddHHmmss";

    /**
     * 日期时间格式：yyyy.MM.dd HH:mm:ss
     */
    public static final String SETTLE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间式：HHmm
     */
    public static final String HOUR_OF_MINUTE = "HHmm";

    /**
     * 时间式：YYYY_MM
     */
    public static final String YYYY_MM = "YYYY_MM";

    /**
     * 日期时间格式：yyyyMMdd HH:mm:ss
     */
    public static final String DATE_FULL_PATTERN = "yyyyMMdd HH:mm:ss";

    /**
     * 日期时间格式：yyyyMMddHHmm
     */
    public static final String YEAR_OF_MINUTE = "yyyyMMddHHmm";

    /**
     * 日期时间格式：yyyy-MM-dd HH:mm
     */
    public static final String YMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 日期时间格式：yyyy-MM-dd HH:mm
     */
    public static final String YEAR_MON_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 日期时间格式：d
     */
    public static final String D_PATTERN = "d";
    /**
     * 日期时间格式：yyyy年M月
     */
    public static final String YYYY_M_PATTERN = "yyyy年M月";

    /**
     * 开始时间后缀：000000
     */
    public static final String START_TIME_SUFFIX = "000000";

    /**
     * 1、获取当前时间（yyyy-MM-dd HH：mm：ss）（返回Date类型）
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        return DateTime.now().toDate();
    }

    /**
     * 2、获取当前时间 格式：yyyyMMddHHmmss  （返回String类型）
     *
     * @return String
     */
    public static String getCurrent() {
        return getCurrent(FULL_PATTERN);
    }

    /**
     * 3、获取当前时间 格式：yyyyMMdd （返回String类型）
     *
     * @return String
     */
    public static String getCurrentStr() {
        return getCurrent(DATE_PATTERN);
    }

    /**
     * 4、根据格式规范返回当前时间 （返回String类型）
     *
     * @param pattern 格式规范
     * @return String
     */
    public static String getCurrent(String pattern) {
        return DateTime.now().toString(pattern);
    }

    /**
     * 5、将String【格式：yyyyMMddHHmiss】类型转换成Date类型
     *
     * @param date 格式：yyyyMMddHHmiss
     * @return Date
     */
    public static Date parse(String date) {
        if (StringUtil.isNotBlank(date) && date.length() > 14) {
            return parse(date, FULL_PATTERNS);
        }
        return parse(date, DATE_PATTERN);
    }

    /**
     * 6、将String 【yyyyMMddHHmiss】类型转换成Date类型
     *
     * @param date    格式：yyyyMMdd
     * @param pattern 格式：yyyyMMdd
     * @return Date
     */
    public static Date parse(String date, String pattern) {
        DateTime dateTime = parseTime(date, pattern);
        if (dateTime == null) {
            return null;
        }
        return dateTime.toDate();
    }

    /**
     * 7、将String 【yyyyMMddHHmiss】类型转换成Date类型
     *
     * @param date    格式：yyyyMMddHHmiss
     * @param pattern yyyyMMddHHmiss
     * @return DateTime
     */
    public static DateTime parseTime(String date, String pattern) {
        if (StringUtil.isBlank(date)) {
            return null;
        }
        if (FULL_PATTERN.equals(pattern)) {
            return DateTimeFormat.forPattern(pattern).parseDateTime(StringUtil.rightPad(date, 14, '0'));
        } else {
            return DateTimeFormat.forPattern(pattern).parseDateTime(date);
        }
    }

    /**
     * 8、将Date类型转换成 String 【yyyyMMddHHmiss】
     *
     * @param date 时间
     * @return String
     */
    public static String format(Date date) {
        return format(date, FULL_PATTERN);
    }

    /**
     * 9、日期格式处理
     *
     * @param date 会计日
     * @return 会计日字符串
     */
    public static String formatDate(Date date) {
        if (null == date) {
            return null;
        }
        return format(date, DATE_PATTERN);
    }

    /**
     * 10、将Date类型按照固定的模式转换 String
     *
     * @param date    时间
     * @param pattern 格式
     * @return String
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return new DateTime(date).toString(pattern);
    }

    /**
     * 12、增加时间
     *
     * @param date          date
     * @param calendarField the calendar field.
     * @param amount        the amount of date or time to be added to the field.
     * @return Date
     */
    private static Date addDate(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 13、按秒偏移,根据{@code source}得到{@code seconds}秒之后的日期<Br>
     *
     * @param source  , 要求非空
     * @param seconds , 秒数,可以为负
     * @return 新创建的Date对象
     */
    public static Date addSeconds(Date source, int seconds) {
        return addDate(source, Calendar.SECOND, seconds);
    }

    /**
     * 14、当前日期移动天数
     *
     * @param source  日期
     * @param addDays 新增天数
     * @return 新创建的Date对象
     */
    public static Date addDays(Date source, int addDays) {
        return addDate(source, Calendar.DAY_OF_MONTH, addDays);
    }

    /**
     * 15、增加/减少年数
     *
     * @param date 日期
     * @param year +/- 加/减
     * @return 日期
     */
    public static Date addYear(Date date, int year) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(year).toDate();
    }

    /**
     * 16、增加/减少天数
     *
     * @param date 日期
     * @param day  +/- 加/减
     * @return 日期
     */
    public static Date addDay(Date date, int day) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(day).toDate();
    }

    /**
     * 17、当前月份月底
     *
     * @param date 日期
     * @return DateTime
     */
    public static DateTime thisMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMaximumValue();
    }

    /**
     * 18、当前月份月初
     *
     * @param date 日期
     * @return DateTime
     */
    public static DateTime thisMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().withMinimumValue();
    }

    /**
     * 19、是否为月初
     *
     * @param date 日期
     * @return DateTime
     */
    public static boolean isMonthBegin(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMinimumValue();
        return beginDT.equals(dateTime);
    }

    /**
     * 20、是否为月末
     *
     * @param date 日期
     * @return DateTime
     */
    public static boolean isMonthEnd(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime beginDT = dateTime.dayOfMonth().withMaximumValue();
        return beginDT.equals(dateTime);
    }

    /**
     * 21、获取年份
     *
     * @param date 日期
     * @return YEAR
     */
    public static String getYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getYear());
    }

    /**
     * 22、获取月份
     *
     * @param date 日期
     * @return MONTH
     */
    public static String getMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return String.valueOf(dateTime.getMonthOfYear());
    }

    /**
     * 23、获取当前时间
     *
     * @return Date
     */
    public static Date getCurrentDate(String pattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(new DateTime().toString(pattern), format).toDate();
    }

    /**
     * 24、计算两个日期的间隔天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return long     间隔天数(long)
     */
    public static long getBetweenDays(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) {
            return -1;
        }
        long days = endDate.getTime() - startDate.getTime();

        return days / (1000 * 60 * 60 * 24);
    }

    /**
     * 25、获取交易时间，短信发送使用
     *
     * @return 时间字符串
     */
    public static String getTradeTime() {
        return DateTime.now().getYear() + "年" +
                DateTime.now().getMonthOfYear() + "月" +
                DateTime.now().getDayOfMonth() + "日" +
                DateTime.now().getHourOfDay() + "时" +
                DateTime.now().getMinuteOfHour() + "分";
    }

    /**
     * 26、判断传入日期是否为当日
     *
     * @param date 日期
     * @return Boolean
     */
    public static Boolean checkDateInThisDay(Date date) {
        return getBetweenDays(
                new DateTime(date).withTimeAtStartOfDay().toDate(),
                DateTime.now().toDate()) <= 0;
    }

    /**
     * 27、判断传入日期是否为当月
     *
     * @param date 日期
     * @return Boolean
     */
    public static Boolean checkDateInThisMonth(Date date) {
        return getBetweenDays(
                new DateTime(date).dayOfMonth().withMaximumValue().withTimeAtStartOfDay().toDate(),
                DateTime.now().toDate()) <= 0;
    }

    /**
     * 28、判断传入日期是否为当年
     *
     * @param date 日期
     * @return Boolean
     */
    public static Boolean checkDateInThisYear(Date date) {
        return getBetweenDays(
                new DateTime(date).dayOfYear().withMaximumValue().withTimeAtStartOfDay().toDate(),
                DateTime.now().toDate()) <= 0;
    }

    /**
     * 29、增加/减少月数
     *
     * @param date 日期
     * @param months  +/- 加/减
     * @return 日期
     */
    public static Date addMonth(Date date, int months) {
        if (date == null) {
            date = getCurrentDate();
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 获取指定日期的前一天
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            return specifiedDay;
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayAfter = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的后一天
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(DATE_PATTERN).parse(specifiedDay);
        } catch (ParseException e) {
            return specifiedDay;
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat(DATE_PATTERN).format(c.getTime());
        return dayAfter;
    }

    /**
     * 获取两个时间之前相隔的月数
     * @param date1 传入开始时间 格式（yyyyMMdd）
     * @param date2 传入结束时间 格式（yyyyMMdd）
     * @return 相隔月数
     * @throws ParseException
     * add by libin date 2015-07-30
     */
    public static int getIntervalMonth(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        return (c2.get(Calendar.YEAR) - c1
                .get(Calendar.YEAR)) * 12 + c2.get(Calendar.MONTH)
                - c1.get(Calendar.MONTH);
    }

    /**
     * 传入日期和当前日期比较，若早于当前日期返回true；否则返回false
     * @param dateStr
     * @return
     */
    public static boolean toCompareNowDate(String dateStr) {
        Date nowdate=new Date();
        try {
            Date toDate = toDate(dateStr);
            if (toDate == null) {
                return false;
            }
            return toDate.before(nowdate);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将日期格式的字符串（格式yyyyMMdd）转换为日期类型
     *
     * @param dataString 字符串的日期格式
     * @return
     */
    public static Date toDate(String dataString) {
        if (StringUtil.isBlank(dataString)) {
            return null;
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(DATE_PATTERN);
        try {
            return new Date(myFormat.parse(dataString).getTime());
        } catch (Exception e) {
            log.error("toDate转换异常:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 20220304 -> 2022-03-04
     *
     * @param date int
     * @return String
     */
    public static String dateFormat(String date) {
        Date formatDate = null;
        try {
            formatDate = FastDateFormat.getInstance(DATE_PATTERN).parse(date);
        } catch (Exception e) {
            log.error("dateFormat fail mag->" + e.getMessage());
            return "";
        }
        return FastDateFormat.getInstance(YEAR_MON_DATE_PATTERN).format(formatDate);
    }


    /**
     * 获取传入年月日所在月份的第一天
     * @param yearMonth 年月日 格式(yyyyMMdd)
     * @param monthSpace 月间隔 如 0 当月 1 下个月
     * @return 所在月份的第一天
     * add by libin date 2015-07-30
     */
    public static String getFirstDayOfMonth(String yearMonth, int monthSpace) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        Date date = sdf.parse(yearMonth);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, monthSpace);
        Date theDate = calendar.getTime();
        //该月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = sdf.format(gcLast.getTime());
        return day_first + START_TIME_SUFFIX;
    }

    /**
     * 功能：取应用服务器时间并以"HHmmss"格式返回
     */
    public static String getTimeForLong() {
        return getCurrentDateByFormat("HHmmss");
    }

    public static String getCurrentDateByFormat(String formatStr) {
        long currentTime = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(currentTime);
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(formatStr);
        return formatter.format(date);
    }

    /**
     * 时间比较
     * @param t1 比较时间
     * @param t2 比较时间
     * @return 比较结果 > 0 则 t1>t2
     * add by libin date 2015-08-11
     */
    public static int timeCompare(String t1, String t2) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(formatter.parse(t1));
            c2.setTime(formatter.parse(t2));
        } catch (ParseException e) {
            log.error("timeCompare转换异常:{}", e.getMessage());
        }
        return c1.compareTo(c2);
    }

    /**
     * 判断传入日期是否是当前月
     *
     * @param date 传入时间参数，格式 yyyyMMdd，例如：20220224
     * @return true是当前月；false不是当前月
     */
    public static boolean checkIsCurrentMonth(String date) {
        // 获取年月(yyyyMM)
        String yearMonthDate = date.substring(0, 6);
        // 当前时间(yyyyMM)
        String currentDate = getCurrent(MONTH_PATTERN);
        return yearMonthDate.equals(currentDate);
    }

    /**
     * 判断一个日期是否是当天日期
     *
     * @param date 传入时间参数，格式 yyyyMMdd，例如：20220224
     * @return
     */
    public static boolean isToday(String date) {
        return StringUtil.equals(date, getCurrent(DATE_PATTERN));
    }
}
