package org.lxp.springboot.schedule;

        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;
        import static  java.lang.System.out;

/**
 * Created by linxiaopeng on 2018-3-12.
 * cron, fixdDelay, fixedRate三个属性必须设置一个
 */
@Component
public class ScheduledTask {

    static {
        out.println("调度测试,类加载时间" + System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 10000)
    public void reportCurTimeWithiniDelay(){
        out.println("调度测试,"+"调度方式:[立即开始，固定频率10s调度一次]" + System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 10000)
    public void reportCurTimeWithFixDelay(){
        out.println("调度测试,"+"调度方式：[立即开始，间隔10秒调度一次]" + System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 10000,initialDelay = 10000)
    public void reportCurTimeWithiniDelayAndFixDelay(){
        out.println("调度测试,"+"调度方式：[延迟10秒开始,间隔10秒调度一次]" + System.currentTimeMillis());
    }

    /**
     *
     springboot 似乎没有 年
     “*” 代表整个时间段.

     每一个字段都有一套可以指定有效值，如

     Seconds (秒)         ：可以用数字0－59 表示，
     Minutes(分)          ：可以用数字0－59 表示，
     Hours(时)             ：可以用数字0-23表示,
     Day-of-Month(天) ：可以用数字1-31 中的任一一个值，但要注意一些特别的月份
     Month(月)            ：可以用0-11 或用字符串  “JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC” 表示
     Day-of-Week(每周)：可以用数字1-7表示（1 ＝ 星期日）或用字符口串“SUN, MON, TUE, WED, THU, FRI and SAT”表示

     “/”：为特别单位，表示为“每”如“0/15”表示每隔15分钟执行一次,“0”表示为从“0”分开始, “3/20”表示表示每隔20分钟执行一次，“3”表示从第3分钟开始执行
     “?”：表示每月的某一天，或第周的某一天
     “L”：用于每月，或每周，表示为每月的最后一天，或每个月的最后星期几如“6L”表示“每月的最后一个星期五”
     “W”：表示为最近工作日，如“15W”放在每月（day-of-month）字段上表示为“到本月15日最近的工作日”
     ““#”：是用来指定“的”每月第n个工作日,例 在每周（day-of-week）这个字段中内容为"6#3" or "FRI#3" 则表示“每月第三个星期五”

     Cron表达式的格式：秒 分 时 日 月 周 年(可选)。

     字段名                 允许的值                        允许的特殊字符
     秒                      0-59                             , - * /
     分                      0-59                             , - * /
     小时                     0-23                               , - * /
     日                       1-31                             , - * ? / L W C
     月                       1-12 or JAN-DEC                  , - * /
     周几                     1-7 or SUN-SAT                     , - * ? / L C #
     年 (可选字段)           empty, 1970-2099                      , - * /

     */

    @Scheduled(cron = "*/10 * * * * *")
    public void reportCurTimeWithCron(){
        out.println("调度测试,"+"调度方式：[cron 表达式]" + System.currentTimeMillis());
    }
}
