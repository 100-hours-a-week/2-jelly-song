package week2.assignment.jellyadventure.domain.time;

import static week2.assignment.jellyadventure.util.Util.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContinuousTimeChecker implements Runnable{

    private final LocalDateTime startTime;

    public ContinuousTimeChecker() {
        startTime = LocalDateTime.now();
    }

    @Override
    public void run() {
        while (true) {
            LocalDateTime currentTime = LocalDateTime.now();
            System.out.print("<< [현재 시간]  " + currentTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초 ||")));
            System.out.println("  [게임 이용 시간]  " + Duration.between(startTime, currentTime).getSeconds() + "초 >>");
            sleep(10000L);
        }
    }
}
