Ce dépôt contient trois projets essentiels pour une architecture microservices complète :

1.  **Eureka Server** : Registre de services : Le serveur Eureka agit comme un registre centralisé ou un serveur de decouverte où les microservices s'enregistrent et découvrent les uns les autres.
2.  **API Gateway** : Point d'entrée unique, avec routage dynamique via Eureka, filtre de sécurité et de logs possible.
3.  **Training Microservice** :Microservice de gestion des formations développé avec Spring Boot, permettant la création, la gestion, la recherche, l’export et les statistiques avancées sur les trainings


🛠️ Base de données : MySQL

# Fonctionnalités principales

- CRUD complet sur les formations  
- Recherche combinée (niveau + type + titre)
- Recherche dynamiques (par niveau, type, mot-clé, dates)  
- Pagination et tri par level
- Export PDF(statistiques, listes, rapports)  
- Génération de graphique statistiques 
- Statistiques globales & mensuelles (trainings actifs, passés, par type ...)  
- Suppression automatique des trainings passés  
- consultation des trainings en cours de mois

# Technologies

- Java 17
- Spring Boot 3.4.x
- Spring Data JPA
- MySQL
- OpenPDF – Génération de fichiers PDF
- JFreeChart – Génération de graphiques dans PDF
- Spring Cloud Netflix Eureka (Server & Client)
- Spring Cloud Gateway (API Gateway)
- Maven – gestion de dépendances


