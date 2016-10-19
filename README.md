Students Henchman
=================
## Ogólne
### Wersje
Java JDK 1.8 u101

Android API 16 (Android 4.1+)

Gradle 3.1

Baza danych: MySQL

### Uruchomienie aplikacji
1. gradle clean build
2. nohup java -jar {path_to_app}/build/libs/students-henchman-service-bus-1.0.jar > console.log &

Logi będą znajdować sie w pliku console.log
Aplikacja domyślnie startuje na porcie 8080

#### Zatrzymanie aplikacji
1. ps x | grep students-henchman-service-bus-1.0.jar
2. kill -15 **processId**

## Klient mobilny

Klient mobilny jest lekką aplikacją, która pobiera dane z serwisu i przechowuje wybrany zakres danych lokalnie.

## Serwis

Jego zadaniem jest cykliczne pobieranie udostępnionych danych o planach, zajęciach, grupach oraz odpowiadanie na żądania klientów mobilnych.
