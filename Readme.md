##Overview
This is a ride sharing app allowing irembo to onboard new dirvers and customers to request rides. It has 5 components

##Requirements
Java version 17
Nodejs version 14 and above
Apache maven
MySQL DBMS

##Installation

### Customer App
`cd customer-app`
`npm install`

### Driver App
`cd driver-app`
`npm install`

### Driver Onboarding
`cd driver-onboarding`
`mvn install`

## Driver Onboarding Frontend
`cd driver-onboarding-Frontend`
`npm install`

### Trip App
`cd trip`
`mvn install`


##Usage

### Driver Onboarding
`cd driver-onboarding`
`mvn spring-boot:run`

### Trip App
`cd trip`
`mvn spring-boot:run`

### Customer App
`cd customer-app`
`npm start`
Visit http://localhost:4201 on your browser to use the customer app

### Driver App
`cd driver-app`
`npm start`
Visit http://localhost:4202 on your browser to use the driver app

##WW Driver Onboarding Frontend
`cd driver-onboarding-Frontend`
`npm start`
Visit http://localhost:4200 on your browser to use the app



