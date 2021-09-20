# automat.gov.sk-API-Wrapper
Unofficial Java wrapper around API used by automat.gov.sk

# Disclimer
Use at your own risk! This is unofficial wrapper, I have no permision from the creators of the API to use the API or make this wrapper!

## Build
  1. Clone the repository
  
  2. Build the jar file by typing `mvn package`
  
  3. Import `target/covid-automat-lib-1.0.jar` to your project
  
## Usage
 1. Create new instance of `CovidAutomat` class. The constructor takes optional user agent string as argument.
 2. Get the region by calling `getRegionByName` or `getRegionByCode`
 
 For more information view the source code, it is simple.
 
 ## Dependencies
  * Java 8+
  * Jackson 2.14.4
