# plagueint
Modelisation of viruses propagation on a worldwide scale

Pour l'UML on utilise UMLet (paquet umlet sous arch)

Manuel Git:
#Créer un dépôt avec git init pour chaque projet, puis placer les codes dans le même dossier que le .git. Attention il faut absolument faire commit car git crée une branche mais
#origin est un alias pointant vers le serveur
* Configurer git: git config --(option)
#par défaut git config configure pour le dépôt (local), on peut configurer en global avec --global
* Initialiser un dépôt git: mkdir (path) && cd (path) && git init
* Faire d'un dépôt un seveur: cd (path_depot) && git init --bare
* Créer un dépôt Git: mkdir (path) && cd (path) && git init
* Cloner un dépôt Git dans un dossier: git clone (url dépôt)
* Ajouter une branche du serveur sur son git local: git fetch (nom_de_la_branche)
* Connaître les fichiers modifiés récemment: cd (chemin_dépôt) && git status.
* Connaître les modifications récentes que l'on a effectués: cd (path) && git diff
* Ajouter des fichiers à la liste pour le commit après chaque modif.: git add filename1 ... filenamex
* Effectuer le commit: git commit
* Commit tous les fichiers changés : git commit -a 
* Consulter les logs de git: git log
* Montrer les lignes de codes modifiés depuis dernier commit: git log -p
* Modifier un commit: git commit --amend
* Annuler le dernier commit sans changement des fichiers: git reset HEAD^
* Annuler un commit précis sans changement des fichiers: git reset (n° commit)
* Annuler le dernier commit et changement des fichiers: git reset --hard HEAD^
* Annuler les modifs d'un fichier avant un commit: git checkout (path-file)
* Reset <file> as in <commit>: git checkout <commit> <file>
* Ajouter une branche: git branch -b (nom de la branche)
* Enlever un fichier du git add: git reset HEAD -- fichier_a_supprimer
* Merge la branche origin/master (serveur) sur la branche locale master : git pull
* Rebase la branche origin/master sur la branche locale master: git pull --rebase
#you can actually set up git pull for a given branch to use rebase instead of merge by setting the config parameter branch.<name>.rebase to true.
* Envoyer ses commits au serveur: git push
* Définir la branche <branch> comme branche par défaut qui est upstream lors d'un push: git push --set-upstream origin <branch>
* Push uniquement la brannche <branch> sur le serveur: git push origin <branch>
* Supprimer une branche sur serveur: git push :<branch>
* Annuler un commit publié: git revert (qques premier chiffres de l'ID du commit) && git push
#ie Créer un nouveau commit qui contient l'inverse de <commit> : git revert <commit>
* Créer une branche: git branch ma-branche
* Montrer les branches et si elles suivent un origin : git branch -a
* Créer une branche et se placer directement dedans: git checkout -b ma-branche
* Supprimer une branche une branche locale: git branch -d (nom_branche)
* Supprimer une branche: git branch -D (nom_branche)
* Tracker les changements sur une branche du serveur: git branch --track branchelocale origin/brancheserveur
* Forcer l'ajout d'une branche: git branch -f dev origin/(nom_branche)
* Supprimer proprement un fichier: git rm nom_du_fichier
* Supprimer le <file> de git et du PC: git rm -f <file>
* Ajouter l'url d'un serveur git à un dépôt local: git remote add origin <url>
* Afficher les infos sur les liens distants: git remote -v
#Résolution propre d'un conflit au lieu de git pull en cas de conflit: [rebase une branche lorsque la branche locale master a divergé de la branche origin/master]
1. git fetch (origin master # si non ajouté) #ajoute les fichiers en cache
2. git rebase origin/master 
3. Faire les changements sur les fichiers en lisant le patch (on a des - et des +) 
4. git add * 
5. git rebase --continue
#git pull fait git fetch+git merge
Mettre à jour une branche déduite de master avec master
1.git checkout next
2.git rebase master
#ie on repart avec le même contenu que master
* Montrer les détails d'un commit: git show <id du commit>
* Obtenir les différences depuis le dernier commit dans le code: git diff
* Obtenir les différences entre deux commit: git diff <commit1> <commit2>
* Ramener sur le pc le dépôt du serveur: git fetch origin
* Faire un commit de merge: git merge --no-ff
* Lorsqu'on veut merge brancheà-fusioné sur master (git checkout master): git merge branche_à_fusionné
#Ainsi on garde des traces de l'intégration au projet
* Supprimer le stash : git stash pop
* Tagger un commit: git tag "nom du tag"
* Montrer qui a modifié quelle ligne sur <file>: git blame <file>
* Vérifier des commits de manière dichotomique: git bisect [start | bad | good]
* Ranger des changements sur si le répertoire de travail est sale por pouvoir pull, push, ou checkout : git stash
* Traiter la suppression, ordre des commits, nom des commit :git rebase -i origin/master

