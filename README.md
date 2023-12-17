# JDBC Quickstart
In this repository, we are going to create a project with JDBC step by step for learning to connect to the database in Java with JDBC.
Working with JDBC in Java is a fundamental skill for interacting with databases. Starting from establishing a connection, performing queries, and updating data, there's a lot to learn. 📚

## What is JDBC?
JDBC is indeed the Java Database Connectivity, which provides exactly! JDBC (Java Database Connectivity) is indeed a Java API that provides a standard interface for accessing relational databases. It allows Java programs to connect to and interact with a wide range of databases using SQL. Through JDBC, developers can execute SQL statements, retrieve results, and update data in a database. JDBC provides a set of classes and interfaces for database operations, making it easier to work with databases in Java applications.

## Dependencies
We use Maven to manage dependencies in our project. For this tutorial, we need PostgreSQL JDBC Driver because we want to connect a database on PostgreSQL
and we have to add the following dependency to your pom.xml.
``` XML
<!-- Add the following dependency to your pom.xml, -->
<!-- replacing LATEST with specific version as required -->

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>LATEST</version>
</dependency>
```

### What is Maven?
🛠️ Maven is a powerful tool commonly used for managing and building Java-based projects. It simplifies the process of project management by automating tasks such as building, packaging, and dependency management. It also provides a standardized way to structure projects and manage project documentation. Overall, Maven helps streamline the development workflow for Java projects.

### What is PostgreSQL JDBC Driver?
The PostgreSQL JDBC Driver, or PgJDBC, is a software component that enables Java applications to interact with a PostgreSQL database using Java code. It is an open-source JDBC driver written in pure Java (Type 4) and communicates using the PostgreSQL native network protocol. 🚀 This driver allows Java programs to establish connections with a PostgreSQL database and execute SQL queries using standard, database-independent Java code. Its use can greatly facilitate the development of Java applications that need to interface with PostgreSQL databases.

## Connect to PostgreSQL
For connection to the database we create the class DatabaseConnectionManager with methode getConnection
that return Connection type. the DatabaseConnectionManager has two fields URL (string) and properties(Properties) that we initialize in its constructor.

```java
public class DatabaseConnectionManager {
    private final String url;
    private final Properties properties;

    public DatabaseConnectionManager(String host, String database, String username, String password){
        this.url = "jdbc:postgresql://"+ host + ":5432/" + database;
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.properties);
    }
}
```
In methode main, we create an instance from DatabaseConnectionManager and call the getConnection method
in this repository we use a shop database you can create and insert data in your PC [this](https://www.w3schools.com/postgresql/postgresql_create_demodatabase.php) link.
