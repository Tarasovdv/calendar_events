package model;

import java.io.Serializable;
import java.util.Calendar;

public class Event implements Serializable {
    private Calendar calendarDate;
    private String eventDate;

    public Event() {
    }

    public Event(Calendar calendarDate, String eventDate) {
        this.calendarDate = calendarDate;
        this.eventDate = eventDate;
    }

    public Calendar getCalendarDate() {
        return calendarDate;
    }

    public String getEventDate() {
        return eventDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "calendarDate=" + calendarDate.getTime() +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
