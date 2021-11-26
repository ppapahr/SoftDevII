package model;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class DocumentManager {
	private HashMap<String, Document> templates;
	
	public DocumentManager(){
		templates = new HashMap<String, Document>();
		Map<Integer, String> templateNames = new HashMap<>();
		templateNames.put(1,"reportTemplate");
		templateNames.put(2,"bookTemplate");
		templateNames.put(3,"articleTemplate");
		templateNames.put(4,"letterTemplate");
		templateNames.put(5,"emptyTemplate");
		
		for (String name : 	templateNames.values()) {
			Document tempDocument = new Document();
			try {
				tempDocument.setContents(getContents(name));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			templates.put(name, tempDocument);
		}
	}
	
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
	public String getContents(String type) throws IOException {
		if(type.equals("articleTemplate")){
			Path fileName = Path.of("templates\\article.txt");
			//String test = Files.readString(fileName);
			//System.out.println(test);
		    return Files.readString(fileName);
		}
		else if(type.equals("bookTemplate")) {
			Path fileName = Path.of("templates\\book.txt");
		    return Files.readString(fileName);
		}
		else if(type.equals("letterTemplate")) {
			Path fileName = Path.of("templates\\letter.txt");
		    return Files.readString(fileName);
		}
		else {
			Path fileName = Path.of("templates\\report.txt");
		    return Files.readString(fileName);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		DocumentManager d = new DocumentManager();
		System.out.println(d.templates.get("letterTemplate").getContents());
		System.out.println("Hello");
	}
}


