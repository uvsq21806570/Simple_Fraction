# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/) si vous n'en possédez pas déjà un.
Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    > Cocher une ou plusieurs cases (concernant les ajouts de fichiers .gitignore ou README par exemple) permet de créer un premier commit (ou commit d'initialisation). Cependant, cocher aucune de ces cases résulte en l'absence d'un premier commit. 

    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    $ git config --global user.name "Mattéo Giraudo"
    $ git config --global user.email matteo.giraudo@ens.uvsq.fr
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    Option utilisée:
    $ git clone https://github.com/uvsq21806570/Simple-Fraction

    Option alternative:
    $ git init
    $ git remote add origin https://github.com/uvsq21806570/Simple-Fraction
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements;
    ```bash
    Compilation : $ javac -d bin/ src/*.java
    Execution : $ java -ea -cp bin Main
    Validation des changements :
    $ git add src/*.java

    On effectue de plus les 2 lignes de commandes suivantes :
    $ git status (Afin de déterminer l'état des fichiers du répertoire)
    $ git log (Afin de consulter l’historique des modifications Git)
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
    Fraction f = new Fraction (4,3);
    assert f.toString().equals("4/3");

    Commandes pour valider les changements :
    $ git status
    $ git add src/
    $ git commit -m "Ajout des fichiers Fraction.java et Main.java"
    ```
1. Publiez vos modifications sur le dépôt distant;
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    $ git remote add origin https://github.com/uvsq21806570/Simple-Fraction (non nécessaire si la distante origin existe déjà)
    $ git push -u origin main
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    > La syntaxe utilisée pour le fichier README.md est le markdown car l'extension précisée est 'md'.

1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull
    ```
    > Le fichier README.md crée sur GitHub est donc présent sur notre machine maintenant.
    
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```bash
    touch .gitignore
    code .gitignore
    Contenu du fichier: *.class
    ```
    > Les fichiers Fraction.class et Main.class seront donc ignorés par git.

1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    Nous allons retirer le fichier settings.json, ajouté lors de la création d'un projet Java sur Visual Studio Code.
    ```
    
    Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    Contenu du fichier .gitignore:
    *.class
    settings.json
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    > Expliquez la procédure de façon synthétique :

    Cette question est réalisée sous Linux. Premierement, nous avons crée une identité et une clé SSH (composée d'une clé privée et clé publique), suivi d'un mot de passe afin d'accéder à cette clé. Ajouter notre clé sur l'agent ssh permettrait de pas écrire notre mot de passe pour pouvoir communiquer entre la forge et notre IDE (ici Visual Studio Code). L'étape suivante est donc d'ajouter la clé publique sur le compte de notre forge en question, ici GitHub. De ce fait, on ouvre en ligne de commande ou directement sur notre IDE le fichier .pub, contenant la clé publique. On la transfère à l'aide d'un copier-coller sur GitHub. Cela permet donc de ne plus à avoir besoin d'utiliser son mot de passe (ou token) pour communiquer entre GitHub et sa machine personnelle, car ces 2 éléments utiliseront la clé SSH pour se reconnaître et ainsi communiquer.

## Partie II (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    L'OS utilisé est Linux Debian.
    Le shell de commande utilisé est bash.
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
    La commande permettant d'obtenir de l'aide est "man".
    Exemple : man git
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        ls -lSh
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        wc -l
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        grep "uneVariable" Main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        grep -r --include "*.java" "uneVariable"
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        find . -type f -name "README.md"
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        diff --text <fichier_1> <fichier_2>
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.

    * `ssh`
        > ssh est un programme utilisé afin d'accéder à des fichiers et répertoires sur un serveur distant. Il permet des communications encryptées et sécurisées entre 2 hôtes (qui sont généralement la machine locale et la machine distante).

    * `screen`/`tmux`
        > Screen est une commande permettant d'ouvrir plusieurs terminaux sur une même console, dans le but d'aider un utilisateur distant en partageant un terminal avec lui.

    * `curl`/[HTTPie](https://httpie.org/)
        > curl est une commande permettant de télécharger et d'envoyer des ressources disponibles sur le réseau (pour lequel le protocole principal est généralement HTTP).
        D'un autre côté, HTTPie est une commande qui permet de debogger et d'intéragir avec des interfaces utilisateur ou des serveurs HTTP. Le développeur peut l'utiliser pour entrer des requêtes HTTP tout en étant hors-ligne mais aussi pour télécharger des fichiers/images.

    * [jq](https://stedolan.github.io/jq/)
        > jq permet de filtrer, découper et regrouper des données de manière à ce qu'un développeur puisse créer des tubes (pipes).Cette commande sera frequemment utilisé afin d'extraire des données et les transformer de manière à les réorganiser.

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    > Eclipse, IntelliJ IDEA et Visual Studio Code. VSC sera le choix considéré pour cette partie.

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    > On sélectionne le fichier sur lequel on souhaite écrire, et on regarde les informations en bas à droite de notre écran. L'encodage utilisé est spécifié (et potentiellement modifiable).

1. Comment choisir le JDK à utiliser dans un projet ?
    > Premièrement, il est nécessaire de télécharger "The Extension Pack for Java". De cette manière, nous pouvons utiliser la palette de commandes (Crtl+Shift+P) et insérer la commande "Java: Configure Java Runtime". Ceci nous ouvre une fenêtre nous permettant de télécharger et utiliser le JDK souhaité pour notre projet.

1. Comment préciser la version Java des sources dans un projet ?
    > Il faut spécifier la version Java dans les scripts de construction (pom.xml pour un projet Maven, build.gradle pour un projet Gradle).

1. Comment ajouter une bibliothèque externe dans un projet ?
    > Cliquer sur "Explorer" nous permet d'accéder à la rubrique "Java Projects". A la fin de cette rubrique, il y a un onglet "Referenced Libraries". Sélectionner le signe " + " de cet onglet nous permet d'ajouter des bibliothèques externes/fichiers jar.
    
1. Comment reformater un fichier source Java ?
    > Il est possible de reformater un fichier source Java avec la commande Ctrl+Shift+i (sur Linux). De plus, il est possible de nouveau d'utiliser la palette de commandes (Crtl+Shift+P) et sélectionner "Java: Open Java Formatter Settings with Preview" afin de gérer les indentations, tabulations, espaces et plus encore. Si rien ne semble se passer, cela signifie que notre fichier Java est déjà formaté.

1. Comment trouver la déclaration d'une variable ou méthode ?
    > En effectuant un clic droit sur une variable ou une méthode, un menu déroulant s'affiche et nous offre l'option "Go to definition" (f12) afin de trouver la déclaration de cette variable ou méthode.

1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    > Effectuer le raccourci ctrl+space dans un fichier source nous propose une liste d'instructions nous permettant d'insérer des blocs de code prédéfinis. La liste propose des options plus précises en adéquation avec le terme que le développeu est en train de rédiger.

1. Comment renommer une classe dans l'ensemble du projet ?
    > Il est possible de renommer une classe dans l'ensemble du projet en sélectionnant son nom et en appuyant sur f2. Ceci nous ouvre une zone de texte qui nous permet d'insérer une nouvelle nomenclature pour notre classe et de confirmer ce changement.

1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > Dans la rubrique Run de VSCode, il est possible d'ajouter des configurations (Add configuration) dans un fichier launch.json, tels que des arguments qui seront passés en paramètre lors de l'exécution du programme en question.

1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > De nouveau, ans la rubrique Run de VSCode, on peut utiliser new breakpoint, afin de générer une pause dans l'exécution de notre programme, ce qui nous permet de visulaiser le contenu des variables souhaitées. Ensuite, on peut saisir le raccourci "f5" afin d'initialiser le débogage de notre programme/projet.

1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?

    > Reformater un fichier source, retrouver les déclarations de variables/méthodes et insérer des snippets sont des fonctionnalités agréablement utiles pour un développeur, peu importe le langage utilisé. Cependant, l'ajout de bibliothèques externes est un atout nécessaire dans l'élaboration de projets courts et longs termes en Java. Enfin, pouvoir modifier le JDK utilisé de notre projet Java simplifie sa conception lorsque plusieurs personnes travaillent dessus (groupe d'étudiants, entreprise, ...).