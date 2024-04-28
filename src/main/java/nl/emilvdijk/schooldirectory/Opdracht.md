## Studenten beheer vervolg
Pas de beheer applicatie die je eerder hebt gemaakt aan zodat deze gebruik gaat maken van classes.

### Student
- Maak nu in plaats van een HashMap voor het bewaren van alle studenten gebruik van een ArrayList.
- Voor een student gebruik je nu geen HashMap meer maar een class Student.
    - Een student heeft een naam, leeftijd, telefoonnummer, e-mail, adres, woonplaats en studentnummer.

### Mentoren
- Maak voor een Mentor een class. Een mentor heeft een naam, leeftijd, telefoonnummer, e-mail, adres,
  woonplaats en werknemernummer.
- Voeg een nieuwe opties aan het menu toe voor:
    - Het toevoegen van een mentor
    - Het verwijderen van een mentor
    - Het weergeven van alle mentoren

### Klassen
- Maak voor een klas een class. Een klas heeft een naam, een mentor en een lijst van studenten.
- Voeg een nieuwe optie aan het menu toe voor:
    - Het toevoegen van een klas
    - Het toevoegen van een student aan een klas
    - Het toevoegen van een mentor aan een klas
    - Het verwijderen van een student uit een klas
    - Het verwijderen van een mentor uit een klas
    - Het verwijderen van een klas
    - Het weergeven van alle klassen

### Aandachts punten
- Maak gebruik van classes voor studenten, mentoren en klassen.
- Maak gebruik van een ArrayList voor het bewaren van studenten, klassen en mentoren.
- Variabelen in het engels, ookal is de opdracht in het nederlands.

## School System
Maak voor het school systeem de nieuwe classes `Person` en `Teacher`. Verplaats alle properties die
voor de classes `Student` en `Teacher` hetzelfde zijn naar de class `Person`. Verplaats `employeeNumber`
naar de class `Teacher`.

Zorg dat de classes `Student` en `Teacher` de juiste classes extenden.