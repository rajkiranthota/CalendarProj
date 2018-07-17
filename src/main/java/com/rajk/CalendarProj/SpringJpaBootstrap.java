
package com.rajk.CalendarProj;

import com.rajk.dao.CalendarEventsRepository;
import com.rajk.dao.CalendarRepository;
import com.rajk.model.Calendar;
import com.rajk.model.CalendarEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rajkiran_Macys
 */

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CalendarRepository calendarRepository;
    private CalendarEventsRepository calendarEventsRepository;


    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setCalendarRepository(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

     @Autowired
    public void setCalendarEventsRepository(CalendarEventsRepository calendarEventsRepository) {
        this.calendarEventsRepository = calendarEventsRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadCalendars();
        loadCalendarEvents();
    }

    private void loadCalendars() {
        Calendar acal = new Calendar();
        acal.setCid( 44 );
        acal.setCname("mycalname");
        acal.setCuser("myuser");
        calendarRepository.save(acal);

        log.info("Saved Calendar - id: " + acal.getCid());

    }
    
    private void loadCalendarEvents() {
        CalendarEvents acalevents = new CalendarEvents();
        acalevents.setCeventId(445);
        acalevents.setCtitle("eventTitle");
        acalevents.setCtime(null);
        acalevents.setCdate(null);
        acalevents.setClocation("eventLocation");
        acalevents.setCattendant("eventAttendant");
        acalevents.setCreminderFlag('N');
        acalevents.setCreminderTime(null);
        calendarEventsRepository.save(acalevents);

        log.info("Saved Calendar Event- id: " + acalevents.getCeventId());

    }

}

