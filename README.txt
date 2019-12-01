Neculai Andreea 324CD
_______________________________________________________________________________

In aceasta tema am implementat jocul folosind Double Dispach.

Initial am creat o harta cu dimensiunile si detaliile preluate din fisierul de 
intrare si o lista de personaje care se vor lupta in joc. Harta este formata din
mai multe campuri de tipurile "land", "volcanic", "woods", "desert". Aceste
campuri contin atat tipul de teren cat si numarul de jucatori care se afla in 
ace arunda, dar si o lista cu indicii jucatorilor din lista initial declarata
la inceputul jocului. La finalul jocului se va afisa numele jucatorului,
daca este mort "dead", daca inca mai traieste, nivelul, experienta, viata,
si pozitia ultimei celule unde se afla.

In fiecare runda jucatorilor li se actualizeaza pozitia, daca nu sunt sub 
actiunea unui atac care ii impiedica sa se deplaseze. Sunt adaugati in celulele
din mapa, doar daca nu au murit. Daca sunt doi jucatori intr-o celula acestia
primesc mai intai "damage over time" din runda anterioara si daca nu a murit 
niciunul acestora li se va scadea viata. Daca un jucator moare, celuilelt i se
va aduga experienta si poate chiar sa treaca la nivelul urmator. Daca amandoi
jucatorii mor, acestora li se a adauga experienta dobandita, dar in cazul in
care vor atinge pragul necesar pentru a evolua, acestia nu o vor face, implicit,
nu li se va restaura viata.
La finalul fiecarei runde, jucatorii sunt scosi din fiecare celula si se va
repeta procesul.

In functie de tipul jucatorului ("Rogue", "Knight", "Pyromancer", "Wizard")
exista doua tipuri de atacuri pecifice care pot afecta mai mult sau mai putin
adversarul. Pentru ca ar fi greu de urmarit codul si o mare parte s-ar putea
repeta, am folosit double dispach pentru a implementa atacurile dintre doi
jucatori. In functie de atac, jucatorul atacat poate primi "damage over time"
sau poate fi obligat sa nu se miste pentru un anumit numar de runde. Daca un 
jucator primeste al doile atac cu repercuriuni, primul va fi anulat automa.

Pe langa double dispach am folosit doua factory -uri, unul pentru crearea 
terenurilor din harta si altul pentru personaje.