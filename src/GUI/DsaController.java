package GUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import module.*;

import java.io.*;

public class DsaController {

    private final FileChooser fileChooser = new FileChooser();
    public DSA des = new DSA();

    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML//KEY
    public TextField keyGTextField;
    public TextField keyHTextField;
    public TextField keyATextField;
    public TextField modNTextField;
    public Button generateKeyButton;

    public Button readKeyButton;
    public Button writeKeyButton;

    @FXML//PLAINTEXT
    public TextField plaintextFileRead;
    public Button plaintextOpenButton;

    public TextArea plaintextTextBox;

    public TextField plaintextFileWrite;
    public Button cyphertextWriteButton;

    @FXML//CYPHERTEXT
    public TextField cyphertextFileRead;
    public Button cyphertextOpenButton;

    public TextArea cyphertextTextBox;

    public TextField cyphertextFileWrite;
    public Button plaintextWriteButton;

    @FXML//RADIO
    public RadioButton fileRadio;
    public RadioButton textboxRadio;

    @FXML//ENCRYPTE, DECRYPTE
    public Button encryptButton;
    public Button decryptButton;


    public void encrypt() {
        if (textboxRadio.isSelected()) {
            if (plaintextTextBox.getText().isEmpty()) {
                DialogBox.dialogAboutError("Plaintext can't be empty!");
                return;
            }
            String plainText = plaintextTextBox.getText();
            // TODO
        }
        if(fileRadio.isSelected()) {
            if (plaintextFileRead.getText().isEmpty()) {
                DialogBox.dialogAboutError("Choose o file!");
                return;
            }
        }
        // TODO
//        cyphertextTextBox.setText(sb.toString());
    }

    public void decrypt() {
        if (textboxRadio.isSelected()) {
            if (cyphertextTextBox.getText().isEmpty()) {
                DialogBox.dialogAboutError("Plaintext can't be empty!");
                return;
            }
            String cypherText = cyphertextTextBox.getText();

            // TODO
        }
        if(fileRadio.isSelected()) {
            if (cyphertextFileRead.getText().isEmpty()) {
                DialogBox.dialogAboutError("Choose o file!");
                return;
            }
        }
        // TODO

//        plaintextTextBox.setText(new String(plainText));

    }

    public void generateKey() {
        // TODO
    }


    //READ FROM FILE & WRITE TO FILE

    private static File configureOpenFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("Choose a file");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        return fileChooser.showOpenDialog(null);
    }


    private static File configureWriteFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("Write a file");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        return fileChooser.showSaveDialog(null);
    }


    public void readKeyFile() {
//        fileChooser.setTitle("Read a private Key");
//        fileChooser.setInitialDirectory(
//                new File(System.getProperty("user.home"))
//        );
//        File file = fileChooser.showOpenDialog(null);
//        if (file == null) {
//            return;
//        }
//        String keyX = null;
//        String mod = null;
//        try {
//            Scanner sc = new Scanner(file);
//            keyX = sc.nextLine();
//            mod = sc.nextLine();
//            sc.close();
//        } catch (FileNotFoundException e) {e.printStackTrace();}
//        if (keyX == null || mod == null) {
//            DialogBox.dialogAboutError("Private key cant be null");
//            return;
//        }
        // TODO
    }

    public void writeKeyFile() {
//        fileChooser.setTitle("Write a private Key");
//        fileChooser.setInitialDirectory(
//                new File(System.getProperty("user.home"))
//        );
//        File file = fileChooser.showSaveDialog(null);
//        if (file == null) {
//            return;
//        }
//        try{
//            BufferedWriter out = new BufferedWriter(new FileWriter(file.toString()));
//            String keyA = elGamal.getX().toString();
//            String mod = elGamal.getP().toString();
//            out.write(keyA);
//            out.append('\n');
//            out.append(mod);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    //czytanie z pliku
    public void openPlainText() {
        File file = configureOpenFileChooser(fileChooser);
        if (file == null) {
            return;
        }
        byte[] bytes = null;
        try {
            FileInputStream in = new FileInputStream(file);
            int size = in.available();
            bytes = new byte[size];
            in.read(bytes);
            in.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        if(bytes == null) {
            DialogBox.dialogAboutError("File is empty!");
            return;
        }

//        elGamal.setPlainTextByte(bytes);
//        plaintextFileRead.setText(file.toString());
//        plaintextTextBox.setText(new String(bytes, StandardCharsets.ISO_8859_1));
    }


    public void openCyphertText() {
        File file = null;
        StringBuilder sb = null;
        try {
            file = configureOpenFileChooser(fileChooser);
            BufferedReader in = new BufferedReader(new FileReader(file.toString()));
            sb = new StringBuilder();
            while(in.ready()) {
                sb.append(in.readLine());
                sb.append("\n");
            }
            in.close();
        } catch (IOException e) {e.printStackTrace();}

//        assert sb != null;
//        String[] rows = sb.toString().split("\n");
//        BigInteger[] cipher = new BigInteger[rows.length];
//        for(int i = 0; i < rows.length; i++) {
//            cipher[i] = new BigInteger(rows[i]);
//        }
//
//        elGamal.setCypherText(cipher);
//        cyphertextFileRead.setText(file.toString());
//        cyphertextTextBox.setText(sb.toString());

    }

    public void writePlainText() {
//        byte[] dane = elGamal.getPlainTextByte();
//        File file = configureWriteFileChooser(fileChooser);
//        if (file == null) {
//            return;
//        }
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            out.write(dane);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        plaintextFileWrite.setText(file.toString());
    }


    public void writeCypherText() {
//        BigInteger[] dane = elGamal.getCypherText();
//        File file = configureWriteFileChooser(fileChooser);
//        if (file == null) {
//            return;
//        }
//        try {
//            BufferedWriter out = new BufferedWriter(new FileWriter(file.toString(), StandardCharsets.ISO_8859_1));
//            for(int i = 0; i < dane.length; i++){
//                out.write(dane[i].toString());
//                out.write("\n");
//            }
//            out.close();
//        } catch (IOException e) {e.printStackTrace();}
//        cyphertextFileWrite.setText(file.toString());
    }

}
