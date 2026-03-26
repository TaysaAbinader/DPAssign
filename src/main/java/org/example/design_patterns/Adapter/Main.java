package org.example.design_patterns.Adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface myDate = new CalendarToNewDateAdapter();

        myDate.setYear(2024);
        myDate.setMonth(7);
        myDate.setDay(4);

        System.out.println("Initial Date: " + formatDate(myDate));

        int daysToAdvance = 10;
        myDate.advanceDays(daysToAdvance);
        System.out.println("Advancing " + daysToAdvance + " days: " + formatDate(myDate));

        daysToAdvance = 30;
        myDate.advanceDays(daysToAdvance);
        System.out.println("Advancing " + daysToAdvance + " days: " + formatDate(myDate));
    }
    // Helper method to print the date
    private static String formatDate(NewDateInterface date) {
        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonth(), date.getDay());
    }
}
