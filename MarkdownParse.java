//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.net.URL;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int mark = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);

            if (mark != -1 && openBracket - mark == 1) 
            {
                 openBracket = markdown.indexOf("[", openBracket + 1); //skip this image 
            }
            if (openBracket == -1) break;

            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket == -1) break;

            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen - closeBracket > 1) break;
            if (openParen == -1) break;

            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen == -1) break;

            String link = (markdown.substring(openParen + 1, closeParen).trim());
            if (link.length() > 0 && isValid(link))
            {
                toReturn.add(link);
            }
            currentIndex = closeParen + 1;
        }

        for (int i = 0; i < toReturn.size(); ++i) {
            String currString = toReturn.get(i);

            for (int j = i + 1; j < toReturn.size(); ++j) {
                if (currString.equals(toReturn.get(j))) {
                    toReturn.remove(j);
                    j -= 1;
                }
            }
        }
        return toReturn;
        
    }


    public static boolean isValid(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }


}
//test