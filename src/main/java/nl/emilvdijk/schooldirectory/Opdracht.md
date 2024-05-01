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


## Vervolg SchoolSystem
- Pas je bestaande code aan en pas polymorphisme toe zodat het tonen van een lijst van Studenten of
  Mentoren dezelfde functie(s) kan gebruiken.
- Student
  - Maak een nieuwe class "Subject" een subject heeft de properties "name", "teacher", "maxSize"
    - maxSize geeft de maximale grote aan van de hoeveelheid studenten die het vak kunnen volgen
    - teacher is uiteraard een Teacher object
    - maak een aantal Subjects aan (maak hierbij gebruik van Instancio of DataFaker)
  - Voeg aan de class "Students" een property "subjects" toe. Dit is een `Map` waarbij de key een `Subject` is en de value een `Integer` die het gemiddelde cijfer representeert.
    - Vul voor elke student de map met een aantal subjects en een gemiddeld cijfer
- Teacher
  - Voeg aan de class "Teacher" een map "hoursDeclared" toe, waar de keys alle maanden zijn van het kalender jaar en de values een `boolean`, waar `true` betekent dat de uren voor die maand zijn gedeclareerd en `false` betekent dat de uren nog niet zijn gedeclareerd.
- Mailer
  - Maak een class Mailer met een methode "sendMail" die als parameter zowel een Student als een Teacher kan ontvangen, en als tweede parameter een string.
    - De methode moet een mail sturen naar de email van de student of teacher met de gegeven string als inhoud. Voor nu hoeft het geen echte email te versturen, en is het voldoende om het emailadres en de inhoud naar de console te printen.
  - Voeg een methode aan de StudentManager toe die een mail stuurt aan alle studenten die voor een bepaald vak een onvoldoende hebben. Het vak (Subject) kan als parameter worden meegegeven.
  - Als deze nog niet bestaat voeg dan een class "TeacherManager", voeg hier een methode toe die een mail stuurt naar alle docenten die voor de huidige maand hun uren nog niet hebben gedeclareerd.


