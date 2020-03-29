package com.company;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    List<Document> documents;
    String filepath;

    public Catalog(List<Document> documents, String filepath) {
        this.documents = documents;
        this.filepath = filepath;
    }
    public Catalog(String path) {
        this.documents = new ArrayList<>();
        this.filepath = path;
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Catalog load(String filepath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Catalog catalog = (Catalog) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return catalog;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Document findById(String id) {
        for (Document doc: documents) {
            if(doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    public static void view(Document document) {
        Desktop desktop = Desktop.getDesktop();
        try {
            File file = new File(document.getFilepath());
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
