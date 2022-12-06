# Let's Go Biking!

The goal of the Let’s Go Biking! project is to develop a small app to compute itineraries by reducing as much as possible the distance to cover by foot (by using bikes instead).

For more information, please visit the [project website](https://lms.univ-cotedazur.fr/2022/course/view.php?id=1440&section=10#tabs-tree-start).

## Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on deploying the project on a live system.

### Prerequisites

Requirements for the software and other tools to build and test
- [GIT](https://git-scm.com/)
- [Maven](https://maven.apache.org/)

### Optional

Optional requirements for the software and other tools to build and test
- [ActiveMQ](https://activemq.apache.org/)

### Recommended

Recommended requirements for the software and other tools to build and test
- [Visual Studio](https://visualstudio.microsoft.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Installing

A step by step series of examples that tell you how to get a development
environment running

Download the project

    Git clone https://github.com/MatisPrograms/LetsGoBiking.git

Move directory into the root of the project

    cd "Lets Go Biking"

### Client Side

From root of project Move directory into the client side

    cd "Lets Go Biking - Client"

Build the project
    
    mvn clean install

Run Client Application
    
    mvn exec:java

### Server Side

From root of project Move directory into the server side

    cd "Lets Go Biking - Server"

To build the project. Open _.sln_ file in Visual Studio and build the project

Authorise the server to use these Urls _(Make sure to replace {your_username} with your username of current connected user on your machine)_ from a Administrator Command Prompt

    netsh http add urlacl url=http://+:8088/RoutingService/ user={your_username}
    netsh http add urlacl url=http://+:8088/ProxyService/ user={your_username}

Or run the following commands in a Administrator Command Prompt

Start Proxy Server and SOAP Server from Visual Studio or from command line

    start '.\Proxy Server\bin\Debug\Proxy.exe'
    start '.\SOAP Server\bin\Debug\SOAP Server.exe'

### ActiveMQ

Start ActiveMQ from command line _(activeMq must be added to PATH environment variable or add path to activeMQ in the command)_

    activemq start

## How to use

Now that the server and the client applications are running, you can use the client to compute itineraries. To do so...

## Authors

  - [**Matis HERRMANN**](https://github.com/MatisPrograms)