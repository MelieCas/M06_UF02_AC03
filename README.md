# M06_UF02_AC03

[0,5 punts] De quina lògica d’aplicació s’encarrega el Patró DAO?

S'encarrega de la lògica d'access a dades de l'aplicació.

[0,5 punts] Per què considereu què és útil el patró DAO i en què us ha servit?

Es util per mantenir el codi mes net i escalable, ja que tenim mes separada la logica alhora de accedir les dades també es mes sencill implementar millores al nostre codi sense tenir que canviar altres aspectes de la nostra aplicació

[0,5 punts] Heu hagut de fer cap ajust al vostre codi d’aplicació (Main, Controladors, Vistes, altres classes que no siguin DAO, etc.) ? Si és així, detalleu de forma breu quins canvis heu fet i per què?

He tingut que ajustar el codi del main ya que el nom dels metodes que tenia era diferent als del DAO però res mes.

[1,5 punts] D’igual forma que s’ha fet a l’enunciat, completeu el diagrama de classes de l’activitat A01 de la UF2 incorporant les interfícies, la classe abstracta i els DAOs. Per acoblar això, cal que relacioneu cada classe del model amb el seu DAO (sols aquelles classes que heu treballat a l’A03, no totes!!! ):



[1 punt] Per últim valoreu el paper que hi juga la classe abstracta. És en tots els casos necessària? En el cas de l’activitat A02 de la UF2, on vau emprar JDBC, penseu que seria d’utilitat?   

La classe abstracta ens serveix per implementar els metodes mes generics i no tenir que repetir codi als DAO. No sempre es necessaria ja que si no hi ha metodes generics per tots els DAO no fa falta implementar aquesta part del codi.
