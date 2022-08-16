# Java Gaïa - Dev Diaries
## Le 2022-08-12 - Introduction #1
Ce projet était initialement développer en Python. Il devait répondre à une demande de synchronisation des documents que je possède sur différents supports (disque dur externe, cloud, usb, ...) et sur différents comptes (*Google, Microsoft, ...*).

J'ai décidé de changer de langage de programmation lorsque je me suis rendu compte que mon ambition pour ce développement qui devait tout juste être un *helper* appelé sporadiquement allait être au centre d'une multitude d'autres. Se faisant, j'ai pensé qu'il me fallait un langage plus robuste, non pas que le Python ne se suffise pas, **mais de mon avis personnel** c'est un langage à l'image du ***bash*** un langage qui permet des
développements rapides mais pas assez robustes. Encore une fois, c'est mon avis personnel.

Le Java m'a semblé le langage le plus judicieux pour la raison qu'à la différence du **C** ou **C++** il est moins lourd et plus facile de développement, et par rapport au **C#**, même si aujourd'hui il y a (peut-être) des facilités de compilation, déploiement sur les systèmes Linux, cela ne me semble pas (personnellement) naturel.

Cela a peut-être changé aujourd'hui, une prise de renseignement serait nécessaire.

En conclusion, le Java parce que c'est un langage que je connais. Je souhaitais développer rapidement mon application sans avoir à gérer le changement de système (comme le C ou C++), ou je ne me sentirai pas à "abandonné" si je devais compiler du C# sur du Linux (utilisation de Mono). Le Java m'évitais toutes ces préoccupation  **Maven** disponibles sur les deux systèmes connus est disponible.

## TO DO #1 - Interprétation... #1
Dans un premier temps, le but de ce développement est de fournir une application qui fournira des service, appelable (comme une fonction C, C++, C#, Java) depuis une console (cmd, PowerShell, Bash, ...) sous ce format :

    gaia service(arg1, "arg2", 'arg3', true, 12, 1.5);

Cette commande devra être interprété et exécuter une méthode et dans mon esprit qui dit interprétation dit interpréteur.

Donc, on se lance dans le développement d'un module d'interprétation sur le modèle d'un compileur. Il y aurait des solutions plus simples, mais je pars du principe que l'homme qui se cantonne seulement à ce qu'il connait n'évolue pas. Donc, on se lance dans l'apprentissage de la compilation.

## Compilation Kesako ? #1
Un compilateur (pour simplifier) permet de passer un langage intelligible humain à un langage que comprend la machine. Pour ce faire, avant tout, il faut définir nos modalités de communications avec avec la machine avec une **grammaire*** (Une grammaire est la syntaxe que l'on utilisera pour communiquer avec l'application).
|  |  |
|--|--|
| **axiome** | appel_service |
| **appel_service** | identifiant ‘(‘ liste_argument ‘)’ fin | identifiant ‘(‘ ‘)’ fin** |
| **identifiant** | [a-zA-Z][a-zA-Z0-9]* |
| **fin** | ‘;’ |
| **liste_arguments** | argument ( ‘,’ argument)* |
| **argument** | entier \| booléen \| réel \| chaîne \| caractère \| ‘null’ |
| **entier** | [0-9]+ |
| **booléen** | True \| true \| False \| false |
| **chaîne** | [\”]([^\"]\|\\"\\"\)*[\\"] |
| **caractère** | [\'][a-zA-Z]*[\'] |

