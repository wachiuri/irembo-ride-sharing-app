# Overview
This is a ride sharing app allowing irembo to onboard new dirvers and customers to request rides. It has 6 components

# Requirements
Install the following requirements before moving on
Java JDK version 17  
Nodejs version 14 and above  
Apache maven  
MySQL RDBMS  
Apache kafka  
Mongo db  

# Installation

## Rider App
```
cd rider-app
npm install
```

## Driver App
```
cd driver-app
npm install
```

## Administrative Backend
```
cd administrative-backend
mvn install
```

## Administrative Frontend
```
cd administrative-frontend
npm install
```

## Driver App
```
cd driver-app
mvn install
```

## Rider App
```
cd rider-app
mvn install
```

# Usage on your PC
Run Apache kafka as instructed in it's documentation

## Administrative Backend
Create a schema in your MySQL database and configure it in this file accordingly.  
Open the file administrative-backend\src\main\resources\application.properties. Modify the configurations according to your environment as described in the file.  
Open the file administrative-backend\src\main\resources\spring.properties. Modify the db configurations according to your environment  
```
cd administrative-backend
mvn spring-boot:run
```

## Driver Backend
Open the file driver-backend\src\main\resources\application.properties. Modify the configurations according to your environment as described in the file  
```
cd driver-backend
mvn spring-boot:run
```


## Rider Backend
Open the file rider-backend\src\main\resources\application.properties. Modify the configurations according to your environment as described in the file  
```
cd rider-backend
mvn spring-boot:run
```

## Customer App
```
cd customer-app
npm start
```

Visit http://localhost:4201 on your browser to use the customer app

## Driver App
```
cd driver-app
npm start
```
Visit http://localhost:4202 on your browser to use the driver app

## Driver Onboarding Frontend
```
cd administrative-frontend
npm start
```
Visit http://localhost:4200 on your browser to use the app


# Build for deployment
Run Apache kafka on your server as instructed in it's documentation
## Rider app
```
cd rider-app
ng build
```
Copy all contents of dist/customer-app folder to a web server document root

## Driver app
```
cd driver-app
ng build
```
Copy all contents of dist/driver-app folder to a web server document root

## Administrative Frontend app
```
cd administrative-frontend
ng build
```
Copy all contents of dist/driver-onboarding-frontend folder to a web server document root

## Driver Backend
```
cd driver-backend
mvn package
```
Upload the target/driver-backend-0.0.1-SNAPSHOT.jar file to server running java 17. Run 
```
java -jar driver-backend-0.0.1-SNAPSHOT.jar
```

## Rider Backend
```
cd rider-backend
mvn package
```
Upload the target/rider-backend-0.0.1-SNAPSHOT.jar file to server running java 17. Run 
```
java -jar rider-backend-0.0.1-SNAPSHOT.jar
```

## Administrative Backend
```
cd administrative-backend
mvn package
```
Upload the target/administrative-backend-0.0.1-SNAPSHOT.jar file to server running java 17. Run 
```
java -jar administrative-backend-0.0.1-SNAPSHOT.jar