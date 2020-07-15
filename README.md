# API Coding Task in JAVA
##	General requirements
	
* The application should have basic documentation that lists available endpoints and methods along with their
									request and response signatures.
* The exact api design in terms of total number of endpoints and http verbs is up to you
* Error responses should be returned in case of errors
* Keep your application source code on a public Github / Gitlab repository
* Bonus, but not mandatory, if you can dockerize the development environment , write test cases .

## Data requirements

You are to model a scenario involving the following objects, payload and relationships .
```
CHARACTER	DATA : firstName ( String ) lastName ( String ) , status ( String ‘ACTIVE’ or ‘DEAD’ or ‘UNKNOWN’) ,
								stateOfOrigin ( String ) , gender (String ‘MALE’ or ‘FEMALE’ ) , location ( Location DataType ) , episodes (Episode Data Type ) , created (DateTime)

LOCATION DATA	: name ( String ) , latitude ( double ) , longitude (double) created (DateTime)

EPISODE DATA	: name ( String ) , releaseDate ( dateTime ) , episodeCode ( String ) , characters ( Character
												Data Type ),episodeComments ( Comment Data Type ) ,  created (DateTime)
COMMENTS DATA	: comment (String < 250 characters) , ipAddressLocation (String) created (
```											
## NB :
```																					
* A “CHARACTER OBJECT” has only “ ONE LOCATION” and can feature in “MANY EPISODES”.

* An “EPISODE OBJECT” can have “MANY CHARACTERS” featured in

* An “EPISODE OBJECT” can have “MANY COMMENTS” .

* The fields highligted in “RED” can not be empty

* “created” column refers to time at which the record was saved in the

* Ensure that the dateTime fields have some differences in there values so that u can do a sort in
Ascending order on the data based on the column.

* Popul ate the database with sample data. ( feel free to add other columns if required )

* Kindly use SpringBoot , Java 8 , JSON payload , mysql (preferably)
```
## Task
```
* Episode list endpoint should be sorted by “releaseDate” from oldest to newest and each episode should
be listed along with it the count of comments.

* Comment list Endpoint should be retrieved in reverse chronological order with the public IP address of
the commenter and DateTime they were stored.

* Character Endpoint should accept sort parameters to sort by one of name, gender in ascending or
descending order.

* Character Endpoint should also accept a filter parameter to filter by gender or status or location

* Search for a List of Episodes a Character featured in .

* Add a comment to an Episode Object.
```
# API ENDPOINTS
# 1.) POST – Post a comment on an episode
```
http://codingtestapi.herokuapp.com/api/comments/{id}/episode
```
## Request
* Header - Content-Type: application/json

* Body raw(text)
```{
"comment": "This is just the begining ",
"ipAddress": "192.168.0.1"
}
```
## Response - 200

* Body 
```
{ "created": "2020-07-13T23:33:39.415+00:00", 
"updated": "2020-07-13T23:33:39.415+00:00", 
"comment": "I love it this way I swear down ",
"ipAddress": "192.168.0.1" }
```
# 2.) GET  – 	List of all Episodes
```
http://codingtestapi.herokuapp.com/api/episodes
```
## Response - 200
* Body 
```
{
    "content": [
        {
            "created": "2020-01-18T05:32:57.000+00:00",
            "updated": "2019-09-24T02:48:21.000+00:00",
            "id": 24,
            "name": "velit",
            "releaseDate": "2010-07-23 14:12:52.0",
            "episodeCode": "69c0cadb-d84a-3dd2-8bfc-a44633a6c796",
            "comments": 6
        },
}
```

# 3.) GET  – 	List of all comments
```
http://codingtestapi.herokuapp.com/api/comments
```

## Response - 200
* Body 
```
{
    "content": [
 {
            "created": "2020-07-13T09:13:23.000+00:00",
            "updated": "2019-12-27T12:34:26.000+00:00",
            "comment": "Aut voluptatum similique dolor aut. Dolorem iste voluptas magnam non. Occaecati dolores quod iure est.",
            "ipAddress": "134.242.20.217"
        },
]
}
```
# 4.) GET  – 	List of all characters
```
http://codingtestapi.herokuapp.com/api/characters
```

## Parameters
			
* sortBy	-	firstName / lastName / gender
* dir	-	Asc  / desc
* filterBy-	Gender/ status/location
*Filter	-	NewJersey
*Page	-	Integer
*Size	-	Integer

## Response - 200
* Body 
```
{
    "content": [
 {
            "created": "2019-08-12T01:05:38.000+00:00",
            "updated": "2020-03-21T10:24:36.000+00:00",
            "id": 13,
            "firstName": "Tomasa",
            "lastName": "Kling",
            "status": "ACTIVE",
            "gender": "FEMALE",
            "origin": "mouth"
        },
      ]
}
```

# 5.) GET  – 	Search all episodes a character featured in
```
	http://codingtestapi.herokuapp.com/api/episodes/character/{id}
```

## Response - 200
* Body 
```
{
    "content": [
 {
            "created": "2019-08-12T01:05:38.000+00:00",
            "updated": "2020-03-21T10:24:36.000+00:00",
            "id": 13,
            "firstName": "Tomasa",
            "lastName": "Kling",
            "status": "ACTIVE",
            "gender": "FEMALE",
            "origin": "mouth"
        },
            ]
}
```

