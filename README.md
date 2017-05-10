#  component-urlshortener

Note: Java version 1.8 is required

Below are the details of the rest api exposed and the request and response for the same

Method POST
URL http://localhost:8080/api/account
Desc This api returns add the account details

Request
{
	"accountId":"122"
}

Response
{
  "success": true,
  "description": "Account Added",
  "data": {
    "accountId": "122",
    "password": "aabbdcee"
  }
}

Method POST
Header 
id :122
pwd : aaabcdb
URL http://localhost:8080/api/register
Desc This api will add the url details

Request
{
"accountId":"122",
"url":"http://stackoverflow.com/questions/1567929/website-safe-data-access-architecture-question?rq=1",
"redirectType" : 301
}
  
Response
{
  "success": true,
  "description": "Url details saved",
  "data": {
    "accountId": "122",
    "url": "http://stackoverflow.com/questions/1567929/website-safe-data-access-architecture-question?rq=1",
    "redirectType": 301,
    "shortUrl": "http://short.com/aaabcdb"
  }
}	 

Method GET
Header 
id :122
pwd : aaabcdb
URL http://localhost:8080/api/statistic/{accountId}
Sample : http://localhost:8080/api/statistic/122
Desc This api fetch the the statistics related to particular account id

Response
{
  "success": true,
  "description": "Success",
  "data": "http://stackoverflow.com/questions/1567929/website-safe-data-access-architecture-question?rq=1: 301"
}