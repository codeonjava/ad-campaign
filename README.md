# ad-campaign

* It is Restful api to create and retrieve ad campaigns with level of Unit/Integration test codes. The API is built in Spring Boot to create a standlone Spring-based application.

* The Endpoint is http://localhost:8080/AdCampaign, where the context path is specifed in "application.yml"

* In order to use JSON format, it is used the binary dependency of "jackson-dataformat", similarly Mockito and Junit are used for testing framework.

** Description **

> POST : http://localhost:8080/AdCampaign/api/ad/ is used to create the ad campaign with request body with JSON format.

> GET : http://localhost:8080/AdCampaign/api/ad/{partnerId} is used to fetch the particular active ad campaign(i.e valid till current time + its duration specified) in the memory where {partnerID} is the path variable to fetch selectively.

> GET : http://localhost:8080/AdCampaign/api/ad/ is used to fetch all the ad campaign.







