# Microservices-Docker-Container
Customer-Service & Billing-Service & Running Microservices dans un Docker Container.
Mise en oeuvre d'une application distribuée basée sur deux micro-services en utilisant les bonnes pratiques :

  - Couches DA0, Service, Web, DTO
  - Utilisation de MapStruct pour le mapping entre les objet Entities et DTO
  - Génération des API-DOCS en utilisant SWAGGER3 (Open API)
  - Communication entre micro-services en utilisant OpenFeign
  - Spring Cloud Gateway
  - Eureka Discovery Service
Déployer des microservices de démarrage à ressort dans un conteneur docker, et orchestrer ce conteneur docker à l'aide de docker compose pour exécuter plusieurs microservices sur un seul réseau, principalement pour permettre des communications de service à service.
