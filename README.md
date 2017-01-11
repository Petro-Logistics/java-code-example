##README
======

###Java APIClient 

This project is a Java API for communicating, retrieving and show data with existing testing resource [Petro Logistics API](https://secure.petro-logistics.com/api/v2/movementsdata).

Javadoc and source JARs are available as well on this branch on **APIClient - bin**


##Parameters

**APIClient** works with 7 parameters:

- Api Key.

Unique key asigned to APICLIENT api.

- Api Hash.

Api Hash maps key to its value. 

- Format.

Data can be transferred in two formats: xml or json 

- CSV with Parameters.

Binary value that indicates to APIClient If CSV is desired with Parameters

- Query Name.

Unique name required to indicate data to be consulted

- Username.

User required to login on testing resource [Petro Logistics API](https://secure.petro-logistics.com/api/v2/movementsdata).

- Password.

Password required to login on testing resource [Petro Logistics API](https://secure.petro-logistics.com/api/v2/movementsdata).


All these parameters are mandatory in order to use APIClient api.

##Usage

As an API, APIClient can be included in any java project where data from resource as [Petro Logistics API](https://secure.petro-logistics.com/api/v2/movementsdata) is required for a Webproject, WebService or another API. 

##Dependencies

APIClient requires the following jars:

- commons-io-2.5-javadoc.jar
- commons-io-2.5.jar
- json-20160810.jar

##Example

An example of how to test APIClient is available on **TestExample.java**.