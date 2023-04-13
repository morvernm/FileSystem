package file2809522;

public class FileTest {
	public static void main(String[] args) {
		Directory coursework = new Directory("coursework");
		File courseworkpdf = new File("courseworkpdf",1);
		File courseworkzip = new File("coursework zip file",2);
		coursework.add(courseworkpdf);
		coursework.add(courseworkzip);

		Directory lectures = new Directory("lectures");
		File lec1 = new File("lecture 1",56);
		File lec2 = new File("lecture 2",20);
		File lec3 = new File("lecture 3", 20);
		coursework.add(lectures);
		lectures.add(lec1); 
		lectures.add(lec2);
		coursework.remove(courseworkzip);
		Directory notes = new Directory("notes");
		notes.add(lec1);
		coursework.add(notes);
		System.out.println(coursework.display("\t"));
//		System.out.println(coursework.search("unit test 1").getName() );
	}
}