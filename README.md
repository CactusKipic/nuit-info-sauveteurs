# nuit-info-sauveteurs
BackEnd de la nuit de l'info 2021

Défi de la nuit  de l'info

API supportant le front-end du défi de la nuit de l'info.

C'est pas bien beau, et oui j'aurais pu prendre le temps d'aller chercher un thème tout fait avec Angular. Mais ça marche nan ? Enfin... Ca marchouille au moins 😊

https://nuitdelinfo.cactus-industries.fr/

##Fonctionnalités :

On peut naviguer parmi tous les sauvetages dans une liste, effectuer une recherche par leur nom et/ou un intervalle de date (avant ET après uniquement). Double cliquer sur une ligne permet de visualiser les détails du sauvetage.

Un bouton ‘Editer’ permet de passer en édition de l’objet, tout le monde peut modifier un objet non-validé. Pour modifier un objet validé, ou valider un objet, il faut entrer la clef admin, qui est simplement ‘NuitInfo’.

Il est possible de naviguer à la page détaillée de toutes les personnes indiquées dans la fiche du sauvetage par un double clic sur la ligne.

Tous les sauveteurs et personnes sauvées sont affichable en liste sur le même modèle que les sauvetages. Il est possible d’effectuer une recherche pour chaque par nom. Double cliquer sur une ligne amène à la page détaillée de la personne, qui permet aussi son édition.

Une page Contribuer est disponible avec un formulaire permettant d’ajouter un sauvetage, non-validé, à la base de données. On peut ajouter autant de personnes sauveteurs sur le sauvetage ainsi que de personnes sauvés. Elles seront associées au sauvetage au moment de l’enregistrement.

##Problème connu :

Entrer la mauvaise clef si elle était nécessaire fait planter le site, et il faut retourner à l’accueil. (peut-être corrigé en dernière minute, qui sait)
