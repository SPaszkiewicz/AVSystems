# AVSystems
Program z podstawowymi funkcjami do zarządzania windami napisany w Javie.
Klasy:
ElevatorSystem - stanowiący container dla wind, z którego można wydawać polecenia dla poszczególnych wind oraz wykonywać kolejne kroki symulacji.
Argumenty:
  -liczba wind w systemie

Atrybuty:
  - elevators - lista wind
  - numberOfElevators - liczba wind
 
Metody:
pickup(int, int) - zamawianie windy z zewnątrz i wewnątrz
Argumenty:
  - elevatorId - identyfikator windy
  - floor - piętro docelowe

update(int, int, int) - ustawienie wartości dla poszczególnej windy
  - elevatorId - identyfikator windy
  - currentFloor - miejsce startowe windy
  - nextFloor - aktualny cel windy

status() - zwraca status wind w postaci listy trójek

printStatus() - zwraca status wind w postaci stingów

elevatorStatus(int) - zwraca status dla pojedynczej windy
Argumenty:
  - id - identyfikator windy

manageElevator(int) - wykonuje jeden krok symulacji dla poszczególnej windy
Argumenty:
  - id - identyfikator windy

step() - wykonuje krok symulacji dla wszystkich wind

Directions - enum reprezentujący kierunek poruszania się windy
Metody:
toUnit() - zamienia enum na jednokierunkowy wektor o wartościach 1,0,-1

fromInt(int num) - metoda zamienia wartość liczbową na kierunek i go zwraca
  - num - liczba, która zostanie zamieniowa

Elevator - klasa reprezentująca jedną winde
Argumenty:
  - id - identyfikator windy
Atrybuty:
  - id - identyfikator windy
  - currentFloor - piętro, na którym aktualnie znajduje się winda
  - nextFloor - piętro docelowe windy
  - direction - kierunek, w którym się porusza
  - requests - lista wszystkich zamówień nieobsłużonych do tej windy

Request - klasa reprezentująca liste zamówień do windy
Atrybuty:
  - ordered - lista służąca jako kolejka
  - set - hashmapa sprawdzająca występowanie piętra w zleceniach

Metody:
  remove(int) - usuwa zlecenie ze struktury
  Argumenty:
    - floor - numer piętra, które chcemy usunąc z listy
 
 pop() - zwraca najstasze nieobsłużone zlecenie
 
 add(int, int, int) - dodaje nowe zlecenie chyba, że jest aktualnie rozważane lub jest już w kolejce.
 Argumenty:
  - floor - numer piętra do dodania
  - currentOrder - docelowe piętro windy w czasie dodawania
  - currentFloor - aktualne piętro, na którym znajduje się winda

 containts(int) - sprawdza czy piętro znajduje się w kolejce zleceń
 Argumenty:
  - floor - sprawdzane piętro

isEmpty() - zwraca True, gdy kolejka jest pusta, w przeciwnym przypadku zwraca False
