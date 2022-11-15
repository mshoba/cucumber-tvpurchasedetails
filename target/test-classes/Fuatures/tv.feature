#Author: your.email@your.domain.com
Feature: tv
Background: 
Given User needs to login amazon

  Scenario: Tv Purchase   
    Given User needs to login amazon 
    When user can search tv
    And user can choose the mobile
    And user validate another option
    Then user receives confirmation information

    Scenario: Tv Purchase   
    When user can search tv with one dim list
    |sony tv| |lg tv|
    And user can choose the mobile
    And user validate another option
    Then user receives confirmation information
    
    Scenario: Tv Purchase   
    When user can search tv with one dim map
    |tv1|sony tv| 
    |tv2|lg tv|
    And user can choose the mobile
    And user validate another option
    Then user receives confirmation information
    
    Scenario Outline: Tv Purchase   
    Given User needs to login amazon "<tv>"
    When user can search tv
    And user can choose the mobile
    And user validate another option
    Then user receives confirmation information
    
    Examples:
    |sony tv|
    |lg tv|
    
    