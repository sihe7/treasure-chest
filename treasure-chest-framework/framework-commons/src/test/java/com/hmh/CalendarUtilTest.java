package com.hmh;

import com.hmh.utils.CalendarUtil;
import com.hmh.utils.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-06-30 16:29
 **/
@SpringBootTest(classes = CalendarUtil.class)
public class CalendarUtilTest {
    @Test
    public void test01(){
        System.out.println("获取当天日期:" + CalendarUtil.getNowTime("yyyy-MM-dd"));
        System.out.println(StringUtil.isEmpty("ss"));
        System.out.println("获取本周一日期:" + CalendarUtil.getMondayOFWeek());
        System.out.println("获取本周日的日期~:" + CalendarUtil.getCurrentWeekday());
        System.out.println("获取上周一日期:" + CalendarUtil.getPreviousWeekday());
        System.out.println("获取上周日日期:" + CalendarUtil.getPreviousWeekSunday());
        System.out.println("获取下周一日期:" + CalendarUtil.getNextMonday());
        System.out.println("获取下周日日期:" + CalendarUtil.getNextSunday());
        System.out.println("获得相应周的周六的日期:" + CalendarUtil.getNowTime("yyyy-MM-dd"));
        System.out.println("获取本月第一天日期:" + CalendarUtil.getFirstDayOfMonth());
        System.out.println("获取本月最后一天日期:" + CalendarUtil.getDefaultDay());
        System.out.println("获取上月第一天日期:" + CalendarUtil.getPreviousMonthFirst());
        System.out.println("获取上月最后一天的日期:" + CalendarUtil.getPreviousMonthEnd());
        System.out.println("获取下月第一天日期:" + CalendarUtil.getNextMonthFirst());
        System.out.println("获取下月最后一天日期:" + CalendarUtil.getNextMonthEnd());
        System.out.println("获取本年的第一天日期:" + CalendarUtil.getCurrentYearFirst());
        System.out.println("获取本年最后一天日期:" + CalendarUtil.getCurrentYearEnd());
        System.out.println("获取去年的第一天日期:" + CalendarUtil.getPreviousYearFirst());
        System.out.println("获取去年的最后一天日期:" + CalendarUtil.getPreviousYearEnd());
        System.out.println("获取明年第一天日期:" + CalendarUtil.getNextYearFirst());
        System.out.println("获取明年最后一天日期:" + CalendarUtil.getNextYearEnd());
        System.out.println("获取本季度第一天:" + CalendarUtil.getThisSeasonFirstTime(11));
        System.out.println("获取本季度最后一天:" + CalendarUtil.getThisSeasonFinallyTime(11));
        System.out.println("获取两个日期之间间隔天数2008-12-1~2008-9.29:" + CalendarUtil.getTwoDay("2008-12-1", "2008-9-29"));
        System.out.println("---------------->");
        System.out.println("获取当前月的第几周：" + CalendarUtil.getWeekOfMonth());
        System.out.println("获取当前年份：" + CalendarUtil.getYear());
        System.out.println("获取当前月份：" + CalendarUtil.getMonth());
        System.out.println("获取今天在本年的第几天：" + CalendarUtil.getDayOfYear());

        System.out.println("获得今天在本月的第几天(获得当前日)：" + CalendarUtil.getDayOfMonth());
        System.out.println("获得今天在本周的第几天：" + CalendarUtil.getDayOfWeek());
        System.out.println("获得半年后的日期：" + CalendarUtil.convertDateToString(CalendarUtil.getTimeYearNext()));

    }
}
