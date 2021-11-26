package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Document {
	private String author;
	private String date;
	private String copyright;
	private String versionID = "0";
	private String contents;
	
	public Document(String author, String date, String copyright, String versionID, String contents) {
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
	}
	
	
	public Document() {
		// TODO Auto-generated constructor stub
		this.contents = "";
		this.author = "";
		this.date = "";
		this.copyright = "";
	}


	public String getContents() {
		return contents;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getCopyright() {
		return copyright;
	}
	
	public String getVersionID() {
		return versionID;
	}
	

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}


	public void save(String filename) {
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(filename));
			
			printWriter.write(contents);
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document clone() {
		return new Document(author, date, copyright, versionID, contents);
	}

	public void changeVersion() {
		int n = Integer.parseInt(versionID);
		versionID = (n + 1) + "";
	}
	
}
