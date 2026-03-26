package org.example.design_patterns.Adapter;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarToNewDateAdapter implements NewDateInterface{
    private Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = new GregorianCalendar();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Calendar months are 0-based, so subtract 1
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Add 1 to return to human-readable month format
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
