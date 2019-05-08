package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId,  LocalDate date, int hours) {
        this.id = 1L;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId,  LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {
        this.id = 0;
    }

    public TimeEntry(TimeEntry timeEntryToCreate) {
        if (timeEntryToCreate.getId() == 0) {
            this.id = 1;
        } else {
            this.id = timeEntryToCreate.getId();
        }
        this.projectId = timeEntryToCreate.getProjectId();
        this.userId = timeEntryToCreate.getUserId();
        this.date = timeEntryToCreate.getDate();
        this.hours = timeEntryToCreate.getHours();
    }
/*
    public SELF isEqualTo( TimeEntry expected) {
        boolean ret = true;

        if (this.id == expected.getId() &&
            this.projectId == expected.getProjectId() &&
            this.hours == expected.getHours() &&
            this.date == expected.getDate() &&
            this.userId == expected.getUserId()) {
            ret = true;
        }

        return this;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }

    public long getId() {
        return this.id;
    }
    public long getProjectId() { return this.projectId;}
    public long getUserId() { return this.userId;}
    public LocalDate getDate() {return this.date;}
    public int getHours() {return this.hours;}
}
