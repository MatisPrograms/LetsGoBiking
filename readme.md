<p align="center">
  <a href="https://example.com/">
    <img src="https://images.fineartamerica.com/images-medium-large-5/retro-bicycle-with-wine-in-picnic-nightanddayimages.jpg" alt="Logo" height=300>
  </a>

  <h3 align="center">Let's Go Biking!</h3>

  <p align="center">
    The goal of the Let’s Go Biking! project is to develop a small app to compute itineraries by reducing as much as possible the distance to cover by foot (by using bikes instead).
  </p>
</p>

<br>

For more information, please visit the [project website](https://lms.univ-cotedazur.fr/2022/course/view.php?id=1440&section=10#tabs-tree-start).

# Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on deploying the project on a live system.

## Prerequisites

Requirements for the software and other tools to build and test
- [GIT](https://git-scm.com/)
- [Maven](https://maven.apache.org/)

## Optional

Optional requirements for the software and other tools to build and test
- [ActiveMQ](https://activemq.apache.org/)

## Recommended

Recommended requirements for the software and other tools to build and test
- [Visual Studio](https://visualstudio.microsoft.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

# Installing

A step by step series of examples that tell you how to get a development
environment running

Download the project

    Git clone https://github.com/MatisPrograms/LetsGoBiking.git

Move directory into the root of the project

    cd "Lets Go Biking"

## Client Side

From root of project Move directory into the client side

    cd "Lets Go Biking - Client"

Build the project
    
    mvn clean install

Run Client Application
    
    mvn exec:java

## Server Side

From root of project Move directory into the server side

    cd "Lets Go Biking - Server"

To build the project. Open _.sln_ file in Visual Studio and build the project

Authorise the server to use these Urls _(Make sure to replace {your_username} with your username of current connected user on your machine)_ from a Administrator Command Prompt

    netsh http add urlacl url=http://+:8088/RoutingService/ user={your_username}
    netsh http add urlacl url=http://+:8088/ProxyService/ user={your_username}

**Or** run the following commands in a Administrator Command Prompt

Start Proxy Server and SOAP Server from Visual Studio or from command line

    start '.\Proxy Server\bin\Debug\Proxy.exe'
    start '.\SOAP Server\bin\Debug\SOAP Server.exe'

## ActiveMQ - _Optional_

Start ActiveMQ from command line _(activeMq must be added to PATH environment variable or add path to activeMQ in the command)_

    activemq start

# How to use

Now that the server and the client applications are running, you can use the client to compute itineraries.

## Interacting with the GUI

When the GUI is loaded, you can move around the map by dragging the mouse and zomm in and out with the scroll wheel.

Up Right of the Interface, you can select different modes of Map display.
- Open Street
- Virtual Earth
- Hybrid
- Satellite

## Manipulating Waypoints

To compute an itinerary, must must add at least two waypoints. To do so, you have to toggle _"Add Waypoint"_ and then click on the map to add waypoints.

To remove a waypoint, you can click _"Clear Waypoints"_ which will remove all waypoints. Or you can click on a waypoint and press _"Remove Waypoint"_.

## Calculating an itinerary

When two or more waypoints are added, you can compute an itinerary by clicking _"Calculate Route"_, which will compute the itinerary and display it on the map.

Lastly, it's not finished yet, but you can also compute an itinerary by activting _"ActiveMQ"_ and then clicking on _"Live Route"_, which will compute the itinerary and display it on the map but using through la message Queue. The only part missing is the transfer of the itinerary Object from the server to the client.

## Stopping the applications

To stop the applications from running, for the client side, all you need to do is close the window. For the server side, you must for both terminal that was opened, press any key. And for ActiveMQ, send a _"Ctrl + C"_ signal to the terminal.

## Built With

  - [**Java**](https://www.java.com/) - Programming Language
  - [**C#**](https://docs.microsoft.com/en-us/dotnet/csharp/) - Programming Language
  - [**Maven**](https://maven.apache.org/) - Dependency Management
  - [**ActiveMQ**](https://activemq.apache.org/) - Message Queue
  - [**JCDecaux**](https://developer.jcdecaux.com/) - Bike Station Provider
  - [**JXMapViewer2**](https://github.com/msteiger/jxmapviewer2) - Map Viewer
  - [**OpenStreetMap**](https://www.openstreetmap.org/) - Map Provider
  - [**GraphHopper**](https://www.graphhopper.com/) - Routing Engine
  - [**SOAP**](https://www.w3.org/TR/soap12-part0/) - Web Service Protocol
  - [**WSDL**](https://www.w3.org/TR/wsdl/) - Web Service Description Language

## Authors

  - [**Matis HERRMANN**](https://github.com/MatisPrograms)