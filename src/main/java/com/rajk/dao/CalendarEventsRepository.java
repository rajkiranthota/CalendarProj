/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.dao;

import com.rajk.model.CalendarEvents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/**
 *
 * @author Rajkiran_Macys
 */

@RepositoryRestResource
public interface CalendarEventsRepository extends CrudRepository<CalendarEvents, Integer>{
}

