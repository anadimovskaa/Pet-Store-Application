 🐾 Pet Store Management Application

 A **Spring Boot**-based web application designed to manage a fictional pet store. This project demonstrates RESTful API development, dynamic data handling, and template rendering with 
 **Thymeleaf**, backed by a lightweight **H2 in-memory database**. It is built to showcase both backend logic and basic frontend integration, suitable for extending into a full-stack solution.


✅ Key Features

- 🐶 **Pet Management**: Create, list, and view pets with type, age, and pricing.
- 👤 **User Interaction**: Simulate pet purchases by users and track transaction outcomes.
- 📈 **Dynamic Pricing**: Calculate the price of a pet based on defined logic.
- 📄 **Buy History Log**: Record successful and unsuccessful pet purchases.
- 🌐 **REST API**: Exposes endpoints to test core features via Postman or curl.
- 🖥️ **Thymeleaf Integration**: Basic HTML UI for manual data entry.
- 💾 **In-Memory Persistence**: Uses **H2 database** for easy testing without external setup.

🧰 Technologies Used

| Layer               | Technology             |
|--------------------|------------------------|
| Backend Framework  | Spring Boot            |
| Template Engine    | Thymeleaf              |
| Persistence        | Spring Data JPA, H2    |
| Build Tool         | Maven                  |
| Language           | Java 17                |
| Testing            | Spring Boot Test, JUnit|


⚙️ Getting Started

 1. Clone the Repository

```bash
git clone https://github.com/your-username/pet-store-application.git
cd pet-store-application
 ```

2.Run the application

Make sure Java 17+ and Maven are installed.

3. Access the Application
H2 Console: http://localhost:9090/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: password

Thymeleaf HTML Form (Pet Creation):
http://localhost:9090/pets/add


🧑‍💻 Author
Ana Dimovska
Student at FINKI 
📧 anadimovska2003@gmail.com
🔗 LinkedIn https://www.linkedin.com/in/ana-dimovska-2b196126a/






