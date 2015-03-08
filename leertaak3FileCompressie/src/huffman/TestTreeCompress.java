package huffman;

import junit.framework.TestCase;
import org.apache.common.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tanja on 8-3-2015.
 */
public class TestFileCompression extends TestCase
{
    @Test
    public void testResults()
    {
        String sep = File.pathSeparator;

        File infile = new File("data" + sep + "TestA.dat");
        File outfile = new File("data" + sep + "TestA.dat.uc");

        try
        {
            Hzip.compress("data" + sep + "TestA.dat");
            Hzip.uncompress("data" + sep + "TestA.dat.huf");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            if(!FileUtils.contentEquals(infile,outfile)){
                fail();
            }

        } catch (IOException e)
        {
            e.printStackTrace();
            fail();
        }
    }

}