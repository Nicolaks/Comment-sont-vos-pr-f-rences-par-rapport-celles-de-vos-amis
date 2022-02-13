Projet Annuel - Master 2  Informatique DOP
Navid S.., Nicolas A.., Lucie Lep

"Quels sont vos préférences par rapport à celles de vos amis ?"

*********CONTENU DU PROGRAMME**********************************************
ressources: tout fichiers à utiliser
src: code principal
	-Main.java
	-src.calculation:
		-src.calculation.algorithm: EPM
		-src.calculation.heuristic: BeamSearch
		-src.calculation.matrix: calculs de matrices
			-Matrix.java
		-Deviation.java ; calcul de deviation
		-....: calculs de ranking
	-src.data: pour utiliser diverses donnees de preference
		-Item.java : un item général
		-Person.java: un individu général
		-Parser.java: un parser générique
		-src.data.sushiSet : donnees specifiques au dataset de sushi
			-ParserSushiSet.java : parser pour recupérer les données 
			des fichiers et creer les matrices de preference
			-Sushi.java: item specifique de type sushi
			-User.java: individu specifique de type répondant au questionnaire des sushis 
		

bin : output pour l'execution
***************************************************************************

*******EXECUTION***********************************************************
Dans un terminal tapez: sh launcher.sh
Ou bien importez le projet dans un IDE,
et lancez le depuis la classe src/Main.java

***************************************************************************
