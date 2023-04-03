# EventTrackerProject

## Description
This project is for dog owner's who would like to keep track of the different dog kibble they have tried. Personally, my dog has an auto-immune disease and is extremely sensitive to certain foods than others. This application allows the user to log the kibble, brand, and leave a review to remind them of what kibble did or didn't work out for the health of their dog.

| HTTP Verb | URI                  | Request Body | Response Body |
|-----------|----------------------|--------------|---------------|
| GET       | `/api/kibbles`      |              | Collection of representations of all _kibble_ resources |collection** endpoint |
| GET       | `/api/kibbles/1`   |              | Representation of _kibbles_ `1` |
| POST      | `/api/kibbles`      | Representation of a new _kibble_ resource | Description of the result of the operation | **
| PUT       | `/api/kibbles/11`   | Representation of a new version of _kibble_ `11` |
| DELETE    | `/api/kibbles/11`   |              | |

## Technology used
**REST api
**Java
**Eclipse
**Spring Data

## Lessons Learned
	
**Ensure that the table id's in the database are auto-incremented or your program will fail to create a new object. I knew that I needed this but failed to implement when needed until I read my console and was able to fix the issue quickly.
**The service inferface works very similarly to a Data object analysis. However, the repository was the brains of the query operation. 
**The idea of the repositories took me awhile to understand, but now I understand that the repositories are used to populate data memory from the database and how to implement one in my programs in the future.
	