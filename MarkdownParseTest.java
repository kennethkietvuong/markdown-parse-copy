import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.net.URL;
//javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest


//linux javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar  MarkdownParseTest.java
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore  MarkdownParseTest
//test

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    public String readFile(String filename) throws IOException{
        Path fileName = Path.of(filename);
        String content;
        content = Files.readString(fileName);
        return content;

}
    @Test
    public void testGetLinks()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file.md"));
            assertEquals("Testing for first link", links.get(0), "https://something.com");
            //assertEquals("Testing for second link", links.get(1), "some-thing.html");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test2()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test2.md"));
            System.out.println("links:" + links.size());
            assertEquals(links.isEmpty(), true);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test3()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test3.md"));
            assertEquals("Testing for first link", links.get(0), "https://something.com");
          //  assertEquals("Testing for second link", links.get(1), "some-thing.html");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Test
    public void test4()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test4.md"));
            assertEquals(links.isEmpty(), true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile2()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file2.md"));
            assertEquals("Testing for first link", links.get(0), "https://something.com");
           // assertEquals("Testing for second link", links.get(1), "some-page.html");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile3()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file3.md"));
            assertEquals(true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void testfile4()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file4.md"));
            assertEquals(true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile5()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file5.md"));
            assertEquals(true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile6()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file6.md"));
            assertEquals(true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile7()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file7.md"));
            assertEquals(true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testfile8()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file8.md"));
            assertEquals("https://www.google.com/", links.get(0));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

     @Test
    public void testfile9()
    {
        try {
            ArrayList<String> links = MarkdownParse.getLinks(readFile("test-file9.md"));
            assertEquals("check size of list for dupes", 1, links.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Test
    public void testforValidLink()
    {
        try {

            ArrayList<String> links = MarkdownParse.getLinks(readFile("invalidLink.md"));
            assertEquals("no valid links in file", true, links.isEmpty());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
}