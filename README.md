# Room Management API

API służące do zarządzania salami kinowymi. Umożliwia dodawanie, usuwanie, modyfikację oraz wyświetlanie dostępnych sal i filmów, które są wyświetlane w poszczególnych salach.

## Technologie

* Java 1.9
* Spring Boot 2.1.16
* MySQL 8.0.32

## Endpointy

### `GET /rooms`

Zwraca listę wszystkich sal kinowych wraz z ich pojemnością i ilością rzędów.

### `GET /rooms/{id}`

Zwraca salę kinową o podanym `id`.

### `POST /rooms`

Tworzy nową salę kinową. Wymaga podania nazwy, pojemności i ilości rzędów w ciele zapytania.

### `PUT /rooms/{id}`

Modyfikuje istniejącą salę kinową o podanym `id`. Wymaga podania nowej nazwy, pojemności i ilości rzędów w ciele zapytania.

### `DELETE /rooms/{id}`

Usuwa salę kinową o podanym `id`. Jeśli sala jest aktualnie zarezerwowana, to usuwanie nie jest możliwe.

### `GET /movies`

Zwraca listę wszystkich dostępnych filmów.

### `GET /movies/{id}`

Zwraca film o podanym `id`.

### `POST /movies`

Dodaje nowy film. Wymaga podania tytułu i czasu trwania w ciele zapytania.

### `PUT /movies/{id}`

Modyfikuje istniejący film o podanym `id`. Wymaga podania nowego tytułu i czasu trwania w ciele zapytania.

### `DELETE /movies/{id}`

Usuwa film o podanym `id`. Jeśli film jest aktualnie wyświetlany w jakiejś sali, to usuwanie nie jest możliwe.

### `GET /rooms/{id}/reservations`

Zwraca listę rezerwacji dla sali o podanym `id`.

### `POST /reservations`

Tworzy nową rezerwację. Wymaga podania id sali, id filmu, daty i godziny rozpoczęcia, a także ilości miejsc.

### `PUT /reservations/{id}`

Modyfikuje istniejącą rezerwację o podanym `id`. Wymaga podania nowej ilości miejsc w ciele zapytania.

### `DELETE /reservations/{id}`

Usuwa rezerwację o podanym `id`.
