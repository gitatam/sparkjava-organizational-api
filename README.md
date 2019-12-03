# ORGANIZATIONAL NEWS API

A rest REST API for querying and retrieving scoped news and information.

## Versioning

 Organizational-Api-v.1.0

## Author

* **Mathew Gitata**


## Prerequisites
You need the following installed on your machine
* Java
* JDK
* Maven
* Gradle
* IDE - intellijIDEA was used for this project
* Postman
* PostgresSQL database

Run the following commands to confirm installations above

`$ java --version`       //java version`

`$ mvn --version`        //maven version`

`$ gradle --version`     //gradle version`



### Setup Instructions

* Step 1:
Clone this repo: git clone https://github.com/gitatam/sparkjava-organizational-api.git
* Step 2:
Open your terminal and navigate to the repo: cd sparkjava-organizational-api
* Step 3:
Create the development and test databases and tables in psql using command:-

 `$psql < create.sql`

* Step 4:
You can now go ahead and use the project.

  `gradle build`

  `gradle run`
* Step 6:
Open Postman, the api-tester and perfom the various tests.


## Technologies Used

* Java
* Spark
* JSON
* JUnit



## License and Copyright information

This project is licensed under the MIT License.

The MIT License (MIT)

Copyright (c) 2019, Mathew Gitata.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
