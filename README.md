The program fetch the data of the stations and the journeys on startup from the resources folder please place there the following files: 2021-05.csv,2021-06.csv,2021-07.csv, Helsingin_ja_Espoon_kaupunkipy_asemat_avoin.csv
The program upload the files and validates the data and insert them to a database.
the backend can be run by docker( docker-compose build,  docker-compose up) or by spring-tool-suite. 
the code was coded on master branch 
The production version  on prod branch

Front-end React app is in helsinki-bike folder you can run it by npm start
## API Reference

## Station:
#### Get all items

```http
  GET /asema/
```
  Description: 
get all stations paged 
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page |      `number` | **not Required**. page number if empty it returns page 1|

#### Get items sorted

```http
  GET /asema/sorted
```
  Description: 
get Stations sorted by a column 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page` |      `number` | **not Required**. page number if empty it returns page 1|
| `sortedBy` |      `string` | **Required**. column to be sorted by example ID|

```http
  GET /asema/search_capacity
  ```
  Description: 
get Station by capacity

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `capacity`  `number` | id of the station|

```http
  GET /asema/single
```
Description: 
get Station by id
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/location
```
Description: 
get Station by id
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/fivereturn
```
Description: 
get most five return stations
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/fivedeparture
```
Description: 
get most five departure stations
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/totaldeparture
```
Description:                      
get total departure of a certain station
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/totalarrival
```
Description:                      
get total arrival of a certain station
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` |  id of the station|

```http
  POST /asema/upload
```
Description:                      
Uploads the file from resources folder to database
| Description                       
|  :-------------------------------- 
|       Upload the file from the resources folder to database |

```http
  POST /asema/
```
* Description:                      
Creates an asema (Station)

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `asema` |   `Object` |  the station that you want to create


## Journey:
#### Get all items

```http
  GET /journey/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` |      `number` | **not Required**. page number if empty it returns page 1|


## Journey:
#### Get all items sorted

```http
  GET /journey/sorted
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` |      `number` | **not Required**. page number if empty it returns page 1|
| `sortedBy` |      `string` | **not Required**. the column to be sorted by|


```http
  GET /journey/search_departure
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` |      `number` | ** Required**. station ID |

```http
  GET /journey/search_arrival
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` |      `number` | ** Required**. station ID |

```http
  GET /journey/avg_departure
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `idParam` |      `number` | ** Required**. station ID |

```http
  GET /journey/avg_arrival
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `idParam` |      `number` | ** Required**. station ID |

```http
  Post /journey/upload
```
Description                |
:------------------------- |
 | Uploads journeys excel sheets to database |

```http
  Post /journey/
```
Description                |
:------------------------- |
 | create a journey |
Body :
{
private String name;
  namn:"namn",
	nimi:"nimi",
	osoite:"osoite",
  adres:"adres",
  kaupunki:"kaupunki",
  stad:"stad",
  Operator:"operator",
	kapasiteet:1,
   x:1.1,
	 y;1.1
}|
 |  the journey that you want to create in JSON format|
