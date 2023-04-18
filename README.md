# HelsinkibikeApp


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
  Description: 
get Station by capacity
```
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
* Description:
get Station Capacity 
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/fivereturn
```
* Description: 
get most five return stations
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/fivedeparture
```
* Description: 
get most five departure stations
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/totaldeparture
```
* Description:                      
get total departure of a certain station
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` | id of the station|

```http
  GET /asema/totalarrival
```
* Description:                      
get total arrival of a certain station
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idParam` |   `long` |  id of the station|

```http
  POST /asema/upload
```
* Description:                      
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
| `page |      `number` | **not Required**. page number if empty it returns page 1|


## Journey:
#### Get all items
