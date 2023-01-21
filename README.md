# SmartLighting
This project was realized as part of the Cloud of Things module at the Higher School of Communication of Tunis, dedicated to monitor street lights.

This project was created by:
- [Karim Omrane](https://github.com/karygauss03)
- [Mohamed Gazzeh](https://github.com/MedG1)

# Context
This project aims to integrate IoT into street light systems to avoid waste of Energy and detect faulty street light. We aim to:
- **Develop a street light remote system:** Conception and realize a prototype of a street light remote system with the ability to connect and control it remotely
- **Use devices that are easy to install:** When choosing the components to install and work with, an optimal combination of components needs to be chosen to reduce the cost, can be easily installed in existing buildings, easy to work with, and interact with.
- **Reduce the human intervention:** Making the user experience as easy as possible is one of the main objectives, by reducing the human intervention in the street light systems.
- **Scalability:** The network should be salable, which means we could add new street lights to the IoT network’s system easily.

# Technologies
To develop this project we use:
- Wildfly preview 27.0.0 final
- JDK 17.0.2
- Flutter
- Mosquitto broker
- MongoDB
- HC SR-04 Ultrasound
- LDR

# Installation guide
- Clone the repository.
- Create a microprofile-properties.config file in /META-INF folder.
- Package the middleware code into a single.war file with Intellij and place in wildfly/standalone/deployments folder.
- Run wildfly using `standalone.bat` in the bin folder.
- Download the apk and install it on your phone to test the application.

# Deployment Machine
With our school mail, we can get a 100$ voucher inside of Microsoft Azure. With this voucher, we can create a virtual machine capable of hosting the middleware, the mosquitto broker and the database. The virtual machine have the following characteristics:
- Ram: 4GB
- vCPUS: 2
- Ressource disk size: 8GB

# Cerfitication and grading
We have enabled HTTPS with letsencrypt TLS certificate with HSTS enabled as well, ensuring only secure connections are allowed to the middleware.
Enabling TLS1.3 only on wildfly helps to generate A grading on SSLabs.
![Alt text](images\certificate-A.JPG)
