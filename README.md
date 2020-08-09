# Stock-Data-Record-System
This is a Spring Boot application that uses a REST Controller to scrape for data and stores this into a database.

The application uses a webscraping service built from the Jsoup library. This service scrapes a stock's Yahoo Finance page for the float, shares outstanding, historical data, etc. The desired information is extracted from the scraped data and stored into Java objects. Using JPA these data objects act as entities of a database and create tables to store new records. 
