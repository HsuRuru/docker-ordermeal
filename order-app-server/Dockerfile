#### Stage 1: Build the application
# 載入openjdk
#FROM openjdk:12 as build
FROM openjdk:12

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


#### Stage 2: A minimal docker image with command to run the app
FROM openjdk:12

#ARG DEPENDENCY=/app/target/dependency

# Copy project dependencies from the build stage
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=0 /app/target/dependency/BOOT-INF/lib /app/lib
COPY --from=0 /app/target/dependency/META-INF /app/META-INF
COPY --from=0 /app/target/dependency/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.order.springorder.SpringorderApplication"]

#VOLUME /tmp
#ADD target/springorder-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8087
#ENTRYPOINT ["java","-jar","app.jar"]

