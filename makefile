JCC = javac
JFLAGS = -g
JVM = java
#JCP = -cp .:gson-2.2.4.jar --module-path /Users/trevor/Documents/javafx-sdk-17.0.2/lib --add-modules javafx.controls,javafx.fxml
ARGS = -cp "/Users/trevor/Library/Application Support/Code/User/workspaceStorage/465f71982606f47986a6b68e5de6da59/redhat.java/jdt_ws/cryptoModel_1ab850e4/bin:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.graphics.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.fxml.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.swing.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/hamcrest-core-1.3.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.controls.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/junit-4.12.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/gson-2.2.4.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx-swt.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.web.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.base.jar:/Users/trevor/Documents/java/csci13/finalProject/cryptoModel/libraries/javafx.media.jar"
JCPS = -cp .libraries/*.jar --module-path /Users/trevor/Documents/javafx-sdk-17.0.2/lib --add-modules javafx.controls,javafx.fxml
default: CryptoMain.class

CryptoMain.class: CryptoMain.java
	$(JCC) $(JFLAGS) $(JCPS) CryptoMain.java

clean:
	$(RM) *.class

run:
	$(JVM) $(JCPS) $(ARGS) CryptoMain
