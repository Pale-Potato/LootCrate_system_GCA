# LootCrate System

## Projektbeskrivelse

I dette projekt har vi udviklet et LootCrate System i Java. Programmet håndterer spillere, som kan bruge credits til at åbne forskellige loot crates og modtage belønninger.

Formålet med projektet er at arbejde med objektorienteret programmering (OOP) og exception handling, herunder egne exception-klasser, checked og unchecked exceptions, `try-catch`, `throw` og `throws`.

## Klassetyper

Vi har oprettet følgende klasser:

* **Player** – Repræsenterer en spiller med et ID, navn og credits. Klassen håndterer blandt andet tilføjelse og brug af credits.
* **LootCrate** – Repræsenterer en loot crate med et ID, en pris og en belønning. Klassen håndterer åbningen af crates.
* **PlayerManager** – Holder styr på spillerne i systemet og gør det muligt at tilføje og søge efter spillere.
* **Main** – Indeholder programmets metoder, hvor spillere og crates oprettes, og systemets funktionalitet testes.

## Funktionalitet

Programmet kan:

* Oprette spillere med individuelle ID'er, navne og credits.
* Oprette loot crates med individuelle ID'er, priser og belønninger.
* Tilføje credits til spillere.
* Trække credits fra spillere, når de åbner en crate.
* Kontrollere, om en spiller har nok credits til at åbne en crate.
* Tilføje spillere til systemet gennem `PlayerManager`.
* Søge efter spillere gennem deres navn.
* Håndtere ugyldige handlinger ved hjælp af egne exceptions.

## Programmets opbygning

### Klasse – Player

Vi har oprettet klassen `Player`, som repræsenterer en spiller i systemet.

Klassen indeholder følgende attributter:

* `id`
* `name`
* `credits`
  
Derudover indeholder klassen metoder til at hente spillerens oplysninger, vise spillerens detaljer, tilføje credits og bruge credits.

Vi har valgt at placere håndteringen af credits i Player-klassen, da det er spillerens ansvar at holde styr på sin egen credit-balance.

### Klasse – LootCrate

Vi har oprettet klassen `LootCrate`, som repræsenterer de forskellige crates, spilleren kan åbne.

Klassen indeholder følgende attributter:

* `crateId`
* `price`
* `loot`

Derudover indeholder klassen metoden `openCrate()`, som modtager et Player-objekt som parameter.

Når en crate åbnes, forsøger metoden at trække crate-prisen fra spillerens credits gennem `spendCredits()`.

Hvis spilleren har nok credits, gennemføres åbningen, og spilleren modtager sin belønning.

Hvis spilleren ikke har nok credits, bliver der kastet en `NotEnoughCreditsException`.

Vi har valgt denne opdeling, fordi LootCrate skal håndtere selve åbningen, mens Player står for håndteringen af spillerens credits.

### Klasse – PlayerManager

Vi har oprettet klassen `PlayerManager` til at administrere spillerne i systemet.

Klassen indeholder en `ArrayList<Player>`, hvor alle registrerede spillere bliver gemt.

Derudover indeholder klassen metoderne:

* `addPlayer()`
* `findPlayer()`

Vi bruger `addPlayer()` til at tilføje spillere til listen og `findPlayer()` til at søge efter en spiller ud fra dennes navn.

Hvis en spiller ikke findes i listen, bliver der kastet en `PlayerNotFoundException`.

Vi har valgt at oprette en separat PlayerManager, så ansvaret for at administrere og finde spillere ikke ligger i Player- eller LootCrate-klassen.

## Exception Handling

Vi har oprettet tre egne exception-klasser til at håndtere forskellige fejl i systemet.

* **NotEnoughCreditsException** – En checked exception, der bliver kastet, når en spiller forsøger at åbne en crate uden at have nok credits.
* **NegativeAmountException** – En unchecked exception, der bliver kastet, når en spiller forsøger at tilføje et negativt antal credits.
* **PlayerNotFoundException** – En checked exception, der bliver kastet, når systemet forsøger at finde en spiller, som ikke er registreret.

### Throw, throws og try-catch

Vi bruger `throw` til at kaste vores egne exceptions, når en bestemt betingelse ikke er opfyldt.

Vi bruger `throws` i metodeerklæringer til at angive, at en metode kan kaste en exception videre til den klasse, der kalder metoden.

I `LootCrateSystem` bruger vi `try-catch` til at fange exceptions og udskrive passende fejlbeskeder.

På den måde kan vi håndtere fejl uden nødvendigvis at afbryde hele programmets eksekvering.

## Test af exceptions

Vi har arbejdet med at teste forskellige scenarier for at sikre, at vores exception handling fungerer korrekt.

Vi har taget udgangspunkt i følgende scenarier:

* En spiller åbner en crate med tilstrækkeligt mange credits.
* En spiller forsøger at åbne en crate uden nok credits.
* En spiller forsøger at tilføje et negativt antal credits.
* en spiller tilføjer en gyldig mængde credits.
* Systemet forsøger at finde en spiller, som ikke eksisterer.
* ShowDetails print for en spiller.

Gennem testene undersøger vi, hvordan exceptions bliver kastet fra de relevante klasser og efterfølgende fanget med `try-catch`.

Vi udskriver passende fejlbeskeder, så det er tydeligt, hvorfor en handling ikke kunne gennemføres.

## Faglige refleksioner

Gennem projektet har vi arbejdet med flere centrale principper inden for Java-programmering.

**Exception Handling**

Vi har lært, hvordan man kan bruge egne exceptions til at håndtere specifikke fejl i et program.

Ved at oprette vores egne exception-klasser kan vi gøre fejlhåndteringen mere specifik og give brugeren mere relevante fejlbeskeder.

**Checked vs. unchecked exceptions**

Vi har arbejdet med forskellen mellem checked og unchecked exceptions.

Vi bruger checked exceptions til fejl, som vi eksplicit ønsker at håndtere eller sende videre, mens vi bruger unchecked exceptions til situationer, hvor Java ikke kræver eksplicit håndtering.

**Ansvarsfordeling og OOP**

Vi har arbejdet med at fordele programmets funktionalitet mellem flere klasser.

Player håndterer spillerens credits, LootCrate håndterer åbningen af crates, og PlayerManager administrerer spillerne.

Denne opdeling gør programmet mere overskueligt og gør det lettere at vedligeholde og udvide.

**Exception flow**

Vi har lært, at en exception ikke nødvendigvis skal håndteres i den metode, hvor den opstår.

Ved hjælp af `throws` kan en exception sendes videre gennem flere metoder, indtil den bliver fanget med `try-catch`.

Det har givet os en bedre forståelse for, hvordan exception handling fungerer på tværs af flere klasser.

## Konklusion

Projektet har givet os praktisk erfaring med exception handling og objektorienteret programmering i Java.

Vi har arbejdet med at oprette egne exception-klasser, skelne mellem checked og unchecked exceptions og anvende `throw`, `throws` og `try-catch` til at håndtere fejl.

Derudover har vi arbejdet med at strukturere programmet i flere klasser med hver deres ansvarsområde.

Samlet set har projektet givet os en bedre forståelse for, hvordan man kan opbygge Java-programmer med en overskuelig struktur og en mere robust fejlhåndtering.
