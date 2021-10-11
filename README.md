# Vizsgaremek
##### *Mátyási Dániel*  
  
# Prog.hu weboldalának automatizált tesztelése  

Projecthez tartozó linkek az alábbiakban érhetők el
| Név | Link           |
| ------------- |:-------------:| 
| Tesztelt Weblap  |  https://prog.hu/ |
| Tesztesetek     |https://docs.google.com/spreadsheets/d/1r0mwrafkMQafIHHNk72-E0MyyA3JIu9J4tgqWEV5eOI/edit?usp=sharing  |
| Allure report |https://qdancasp.github.io/vizsgaRemek/6/|  
  
***  
## A tesztek az oldal alábbi funkcióit fedik le
- ***Regisztráció:*** Pozitív(sikeres regisztráció),illetve negatív tesztesetek(pl. hiányzó e-mail cím,be nem pipált használati szerződés,stb ).  

A pozitív teszt sikeres futtatásához a `RegistrationTest.java` class alábbi függvényének nick(nicknév),és email(e-mail cím) változóit kell feltölteni egyedi,és még nem használt adatokkal:
```
@Test
@DisplayName("TC-1: Regisztráció; helyes adatokkal")
public void testingValidRegistration(){

        String nick = "";
        String email= "";
```  

- ***Bejelentkezés:*** Pozitív(sikeres bejelentkezés),és negatív tesztesetek(pl. rossz jelszó).  
`LoginTest.java` classban érhető el  

- ***Adatkezelési nyilatkozat használata:*** Adatkezelési nyilatkozat,és sütik elfogadása.  
`PrivacyAndPolicyTest.java` classban érhető el  

- ***Adatok listázása:*** Hírek,videók,cikkek listázása.  
`ListingDatasTest.java` classban érhető el  

- ***Több oldalas lista bejárása:*** Java videók kilistázása,és végigjárása.  
`MultiPageList.java` classban érhető el  

- ***Új adat bevitel:*** Keresés az oldalon.  
`NewDataWithSearh.java` classban érhető el  

- ***Ismételt és sorozatos adatbevitel adatforrásból:*** Felhasználói profil kitöltése.  
`AddDetailsFromDataSourceTest.java` classban érhető el  

- ***Meglévő adat módosítás:*** Felhasználói profil bemutatkozásának módosítása.  
`ChangeDetailsTest.java` classban érhető el  

- ***Adat vagy adatok törlése:*** Felhasználói profil adatainak törlése.  
`DeleteDetails.java` classban érhető el  

- ***Adatok lementése felületről:*** Java videók címeinek lementése.  
`SaveToTxtTest.java` classban érhető el  

- ***Kijelentkezés:*** Felhasználó kijelentkezése.  
`LogoutTest.java` classban érhető el  


---
## Program futtatásához szükséges technológiák
- ***Java***
- ***Maven***
- ***Junit5***
- ***Selenium***

### Egyéb - futtatáshoz nem szükséges - felhasznált eszközök
- ***Github workflow***
- ***Allure report***
***

---
## Vizsgakövetelmények: 
- Web alkalmazás felület tesztelési vizsgaremek vizsgarész  

A vizsgázónak a vizsgát megelőzően egy komplex web alkalmazás alapján felület 
tesztelési projektet kell elkészítenie, saját döntése alapján egy egyénileg választott web alkalmazás alapján.  

A választott teszt alkalmazásnak legalább az alábbi funkcióit kell lefedni: tesztekkel: 
- Regisztráció 
- Bejelentkezés 
- Adatkezelési nyilatkozat használata 
- Adatok listázása 
- Több oldalas lista bejárása 
- Új adat bevitel 
- Ismételt és sorozatos adatbevitel adatforrásból 
- Meglévő adat módosítás 
- Adat vagy adatok törlése 
- Adatok lementése felületről 
- Kijelentkezés  

 A vizsgaremek benyújtásának módja: 
 A kész csomagot a vizsga előtt minimum 7 nappal kell a vizsgabizottsághoz 
benyújtani GitHub vagy más hasonló szolgáltatás segítségével megosztva. A 
megosztott anyagnak tartalmaznia kell az alábbiakat: 
-  A tesztek forráskódja 
- A tesztelt alkalmazás elérési helye (GitHub vagy hasonló) és 
üzembehelyezési módja (Readme.MD vagy más dokumentáció az 
alkalmazás telepítése / elindítási módja) 
- A tesztek dokumentációja a forráskódban és/vagy teszt dokumentációban 
(XLS vagy más táblázatos fájlok formájában) 
- Tesztek futtatásának manuális és automatizált módja 
- Valamilyen formában vezetői tesztjelentés  

A vizsgaremek bemutatására és megvédésére maximum 15 perc áll a vizsgázó 
rendelkezésére.
