package autocomplete;

import autocomplete.gui.View;
import autocomplete.service.Service;
import autocomplete.service.TrieService;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private String readFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private String[] readFromFile()throws IOException{
        String path = View.getPath();
        return readFromFile(path).trim().split("\n");
    }

    public static void main(String[] args)throws IOException{
        Main main = new Main();
        JOptionPane.showMessageDialog(new JFrame(), "This is an autocomplete engine\nCreated by Ankit Sharma, Aekanshu Katyal, and Yashaswee Sharma as the mini-project\nPlease select the correct word-file now\nLet's BEGIN!");
        String[] words = main.readFromFile();
        TrieService service = new Service();
        service.buildTrie(words);
        View view = new View("Autocomplete using Tries", service);
        view.setVisible(true);
    }
}
