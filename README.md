Students Henchman
=================
## Ogólne
### Wersje
Java JDK 1.8 u101

Android API 16 (Android 4.1+)

Gradle 3.1

Baza danych: MySQL

### Uruchomienie serwera
1. gradle clean build
2. java -jar {path_to_app}/build/libs/service-bus-1.0.jar

Domyślnie startuje na porcie 8080

## Klient mobilny

Klient mobilny jest lekką aplikacją, która pobiera dane z serwisu i przechowuje wybrany zakres danych lokalnie.

## Serwis

Jego zadaniem jest cykliczne pobieranie udostępnionych danych o planach, zajęciach, grupach oraz odpowiadanie na żądania klientów mobilnych.
