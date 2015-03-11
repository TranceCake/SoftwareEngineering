package test.huffman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

/**
 * Created by Tanja on 8-3-2015.
 */
public class TestTreeCompress extends TestCase
{final String FILE = "Test3.txt.huf.txt";
    public void testCompr(){
        try {
            Hzip.compress(FILE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Hzip.uncompress(FILE+".huf");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedReader bufUnComp=null;
        BufferedReader bufComp=null;
        try {
            bufUnComp = new BufferedReader(new FileReader(FILE));
            bufComp = new BufferedReader(new FileReader(FILE+".uc"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line1 = null;
        String line2 = null;
        try{
            line1=bufComp.readLine();
            line2=bufUnComp.readLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        if (line1==null || line2==null) fail("One of the two files is empty");
        while(line1!=null && line2!=null){
            assertEquals(line1, line2);
            try {
                line1=bufComp.readLine();
                line2=bufUnComp.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}