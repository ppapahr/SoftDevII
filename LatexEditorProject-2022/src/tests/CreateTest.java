package tests;

import controller.commands.*;
import model.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CreateTest {
	
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	

	@Test
	public void test1() {
		
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass[11pt,twocolumn,a4paper]{article}\r\n" + 
				"\\usepackage{graphicx}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n" + 
				"\r\n" + 
				"\\title{Article: How to Structure a LaTeX Document}\r\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\r\n" + 
				"\\date{\\today}\r\n" + 
				"\\maketitle\r\n" + 
				"\r\n" + 
				"\\section{Section Title 1}\r\n" + 
				"\r\n" + 
				"\\section{Section Title 2}\r\n" + 
				"\r\n" + 
				"\\section{Section Title.....}\r\n" + 
				"\r\n" + 
				"\\section{Conclusion}\r\n" + 
				"\r\n" + 
				"\\section*{References}\r\n" + 
				"\r\n" + 
				"\\end{document}";
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}

	@Test
	public void test2() {
		
		versionsManager.setType("letterTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass{letter}\r\n" + 
				"\\usepackage{hyperref}\r\n" + 
				"\\signature{Sender's Name}\r\n" + 
				"\\address{Sender's address...}\r\n" + 
				"\\begin{document}\r\n" + 
				"\r\n" + 
				"\\begin{letter}{Destination address....}\r\n" + 
				"\\opening{Dear Sir or Madam:}\r\n" + 
				"\r\n" + 
				"I am writing to you ....... \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\\closing{Yours Faithfully,}\r\n" + 
				"\r\n" + 
				"\\ps\r\n" + 
				"\r\n" + 
				"P.S. text ..... \r\n" + 
				"\r\n" + 
				"\\encl{Copyright permission form}\r\n" + 
				"\r\n" + 
				"\\end{letter}\r\n" + 
				"\\end{document}";
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	
	@Test
	public void test3() {
		
		versionsManager.setType("reportTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass[11pt,a4paper]{report}\r\n" + 
				"\r\n" + 
				"\\usepackage{graphicx}\r\n" + 
				"\\begin{document}\r\n" + 
				"\\title{Report Template: How to Structure a LaTeX Document}\r\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\r\n" + 
				"\\date{\\today}\r\n" + 
				"\\maketitle\r\n" + 
				"\r\n" + 
				"\\begin{abstract}\r\n" + 
				"Your abstract goes here... \r\n" + 
				"... \r\n" + 
				"\\end{abstract}\r\n" + 
				"\r\n" + 
				"\\chapter{First Chapter}\r\n" + 
				"\\section{Section Title 1}\r\n" + 
				"\\section{Section Title 2}\r\n" + 
				"\\section{Section Title.....}\r\n" + 
				"\r\n" + 
				"\\chapter{....}\r\n" + 
				"\\chapter{Conclusion}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\\chapter*{References}\r\n" + 
				"\r\n" + 
				"\\end{document}";
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	@Test
	public void test4() {
		
		versionsManager.setType("bookTemplate");
		createCommand.execute();
		
		String contents = "\\documentclass[11pt,a4paper]{book}\r\n" + 
				"\\usepackage{graphicx}\r\n" + 
				" \r\n" + 
				"\\begin{document}\r\n" + 
				"\r\n" + 
				"\\title{Book: How to Structure a LaTeX Document} \r\n" + 
				"\\author{Author1 \\and Author2 \\and ...} \r\n" + 
				"\\date{\\today}\r\n" + 
				"\r\n" + 
				"\\maketitle\r\n" + 
				" \r\n" + 
				"\\frontmatter\r\n" + 
				" \r\n" + 
				"\\chapter{Preface}\r\n" + 
				" \r\n" + 
				"\\mainmatter\r\n" + 
				" \r\n" + 
				"\\chapter{First chapter}\r\n" + 
				" \r\n" + 
				"\\section{Section Title 1} \r\n" + 
				"\\section{Section Title 2} \r\n" + 
				"\\section{Section Title.....}\r\n" + 
				" \r\n" + 
				"\\chapter{....}\r\n" + 
				" \r\n" + 
				"\\chapter{Conclusion}\r\n" + 
				" \r\n" + 
				"\\chapter*{References}\r\n" + 
				" \r\n" + 
				"\\backmatter\r\n" + 
				" \r\n" + 
				"\\chapter{Last note}\r\n" + 
				"\r\n" + 
				"\\end{document}";
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
	
	@Test
	public void test5() {
	
		versionsManager.setType("emptyTemplate");
		createCommand.execute();
		
		String contents = "";
		String actualContents = versionsManager.getCurrentDocument().getContents();
		assertEquals(contents, actualContents);
	}
}