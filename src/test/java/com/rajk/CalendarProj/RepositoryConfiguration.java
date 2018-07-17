/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.CalendarProj;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 *
 * @author Rajkiran_Macys
 */

@Configuration
@EnableAutoConfiguration(exclude=RepositoryConfiguration.class)
@EntityScan(basePackages = {"com.rajk.model"})
@EnableJpaRepositories(basePackages = {"com.rajk.CalendarRepository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}