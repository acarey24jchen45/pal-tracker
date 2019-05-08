package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private List<TimeEntry> entryList;

    public InMemoryTimeEntryRepository() {
        entryList = new ArrayList<>();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry = new TimeEntry(timeEntry.getId(),
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());
        entryList.add(entry);
        return entry;
    }

    public TimeEntry find(long id){
        int idx = -1;
        for(TimeEntry entry: entryList ) {
            if (entry.getId() == id) {
                return entry;
            }
        }

        return null;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        entryList.remove(0);
        entryList.add(timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        if (this.find(id) != null) {
            entryList.remove(id);
        }
    }

    public List<TimeEntry> list() {
        return entryList;
    }
}
