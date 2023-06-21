package Split;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

import java.time.Period;


import static java.time.DayOfWeek.MONDAY;

import static java.time.temporal.TemporalAdjusters.*;

public class SplittDate {
    public static void main(String[] args) throws IOException {
        SplittDate splittDate = new SplittDate();
        splittDate.splitting();
    }


    public void splitting() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String type = reader.readLine().trim();
        String[] dates = reader.readLine().trim().split(" ");
        String startDate = dates[0];
        String endDate = dates[1];
        reader.close();
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        TemporalAmount step = null;
        LocalDate marcer = null;


        switch (type) {
            case "WEEK" -> {
               marcer = start.with(previousOrSame(MONDAY));
                step = Period.ofWeeks(1);
            }
            case "MONTH" -> {
                marcer = start.withDayOfMonth(1);
                step = Period.ofMonths(1);
            }
            case "QUARTER" -> {
                int newMonth = ((start.getMonthValue() - 1) / 3) * 3 + 1;
                marcer = start.withMonth(newMonth).withDayOfMonth(1);
                step = Period.ofMonths(3);
            }
            case "YEAR" -> {
                marcer = start.with(firstDayOfYear());
                step = Period.ofYears(1);
            }
            case "REVIEW" -> {
                int month = start.getMonthValue();
                if (month >= 4 && month < 10) {
                  marcer = start.withMonth(4).withDayOfMonth(1);
                } else {
                 marcer = start.withMonth(10).withDayOfMonth(1);
                }
                step = Period.ofMonths(6);
            }
        }



         StringBuilder sb = new StringBuilder();
        int counter = 0;

        while (marcer.isBefore(end) || marcer.isEqual(end)) {
            sb.append(marcer.isBefore(start) ? start : marcer).append(" ");

            LocalDate stepEnd = marcer.plus(step).minusDays(1);
            sb.append(stepEnd.isBefore(end) ? stepEnd : end).append("\r\n");

            marcer = marcer.plus(step);
            counter++;

        }
        System.out.println(counter);
        System.out.println(sb);


    }
}

