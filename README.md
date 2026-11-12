# Java Learning Projects

- `learning/`: Java fundamentals and Spring/JPA learning examples.
- `springdemo/`: Spring demo project.

Open each project folder separately in your IDE.
For `learning`, set the `DB_PASSWORD` environment variable before starting the database-backed application.

The Class/Object example can run independently of Spring and the database:

```sh
cd learning
javac -encoding UTF-8 --release 21 -d target/class-object-demo src/main/java/com/datajpa/learning/fundamentals/classobject/*.java
java -cp target/class-object-demo com.datajpa.learning.fundamentals.classobject.ClassObjectDemo
```
