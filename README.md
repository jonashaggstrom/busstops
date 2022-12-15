# busstops

## Description
An application that finds out which bus lines that have the most bus stops on their route,  
and presents the top 10 bus lines in a nice and formatted way in a web browser.  
The web page should show the names of every bus stop for each of the bus lines in  
the top 10 list. There are no requirements how the bus stops are sorted.  
To accomplish the task please use the Trafiklab’s open API  
(https://www.trafiklab.se/). You can find more information about the specific API on  
the documentation page: https://www.trafiklab.se/api/sl-hallplatser-och-linjer-2.  
You can register your own account at Trafiklab.  
The data should be automatically gathered from API for each run of the application.  
---
## Usage
Download git repo  
Import in eclipse as maven project  
Run using: `mvn spring-boot:run`  
Open a browser and type in localhost:8080  
Enter a valid trafiklab API key and press submit  
If key is valid, the user should be redirected to the resulting table.  