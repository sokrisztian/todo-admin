# TODO - admin app

- Make sure the *MySQL DB* is set and running well.
- *Java 11* and *Maven* are needed to build and run the app.

## Build

Go to the project's root directory (where *pom.xml* is) and execute:

```
mvn package
```

With this the `todo-admin*.jar` fat jar is created in the *target* folder.

## Run

Go to the `todo-admin*.jar`'s directory and execute:

```
java -jar todo-admin*.jar
```

Make sure the `avatars` folder is next to the `todo-admin*.jar`.
