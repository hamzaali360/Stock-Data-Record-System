# Stock-Data-Record-System

# Summary
This is a Spring Boot application that uses multiple REST controllers to store pattern records into databases. The controllers use a webscraping service built from the Jsoup library to scrape for data. This service scrapes a stock's Yahoo Finance page for the float, shares outstanding, historical data, etc. The desired information is extracted from the scraped data and stored into Java objects; The pattern information the user submits is also stored into Java objects. Using JPA these data objects act as entities of a database and are stored as new records in their respective tables. 

As mention Jsoup was used to build the webscraper service and so it is a required external dependency.

# Purpose
The purpose of this system is to be able to model a chart pattern. Each chart pattern is labeled as a strategy as the end goal is to be able to analyze a patterns data to find predictable behavior to profit from. 

An example of a pattern that was modeled is the morning panic. A morning panic can appear in many forms and occurs between the market open until about an hour and a half in. The structure of the possible behavior of this pattern is zero or one failed morning spikes followed by the panic drop point. Then zero+ failed bounces into the panic bottom point. Then zero+ pullback bounces into the panic top point. Each behavior within a section of the pattern, such as a failed bounce within the failed bounce section, is stored as three points to describe the event. To describe a point the price, time and significance are recorded. Significance refers to behavior related to technical indicators or key levels, for example a bounce off VWAP. 

Any kind of bounce, such as a pullback bounce, is extended from a general bounce. A bounce consists of the drop, bottom and top points. The percentage and time differences between the drop - bottom and bottom - top points are calculated as well. This information is stored into the relevant table within the database of the strategy that it is modeling. 

The next step is to accumaulate a large set of morning panic records to find correlations between price ranges, market capital and share float. 


# Psychology
The psychology behind the pattern is to find a morning sell off on a stock that has been hot recently and ideally has a catalyst (news, etc) to gather positive attention. A sell off occurs when the price drops a lot within a short period of time. This selloff can be an accumulation of stake holders closing their positons and short sellers opening their positions. A big sell off can trigger the stop losses of stake holders resulting in additional mass selling that drives the price down even further. A hot stock with attention can bounce from this kind of sell off and could even run if conditions allowed it to. This particular behavior can be capitalized upon by recognizing that a sell off could eventually be met with a wall of bidders that would absorb the sell orders and cause the price to bounce a bit. If shorts are present and the price is showing no signs of dropping an influx of short sellers covering their positions will contribute to the bounce. Momentum traders may also be present and open positions as a new trend begins to develope. 

It is important to understand that there is no guarantee that a bounce will occur from a selloff. There must be enough buying interest to counter the selloff and cause the price to bounce. Buying interest can be attributed to a positive catalyst attracting attention.

This pattern was tracked on stocks from $0.50 to around $75.
