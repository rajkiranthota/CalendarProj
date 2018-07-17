/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.controller;

import com.rajk.model.Calendar;
import com.rajk.service.CalendarService;
import com.rajk.service.CalendarServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Rajkiran_Macys
 */

@RestController
@RequestMapping("/calendar")
@Api(value="calendars", description="calendar Events")
public class CalendarController {

    private CalendarService calendarService;

    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @ApiOperation(value = "View a list of available Calendars",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Calendar> list(Model model){
        Iterable<Calendar> calendarList = null ; //calendarService.listAllCalendars();
        return calendarList;
    }

    }

    

