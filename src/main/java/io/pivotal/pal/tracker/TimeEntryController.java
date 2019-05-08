package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PostMapping(path = "/time-entries",  produces = "application/json")
    public ResponseEntity  create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(this.timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED)  ;
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        return ResponseEntity.ok(this.timeEntryRepository.find(timeEntryId));
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(this.timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
            if (this.timeEntryRepository.find(timeEntryId) != null) {
                return new ResponseEntity(this.timeEntryRepository.update(timeEntryId, expected), HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
     }
    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
//        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return ResponseEntity.noContent().build();
    }

}
