package com.company;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("C:\\Work\\hello_wold.txt");
        Document doc = new Document("java1", "Java Course 1",
                "C:\\Work\\miampierdutunscriptdingreseala.txt");
        doc.addTag("type", "Slides");
        catalog.addDocument(doc);

        catalog.save();
    }

    private void testLoadView() {
        Catalog catalog = Catalog.load("C:\\Work\\hello_wold.txt");
        Document doc = catalog.findById("java1");
        if(doc != null)
            Catalog.view(doc);
    }
}
