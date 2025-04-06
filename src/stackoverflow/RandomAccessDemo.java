package stackoverflow;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class RandomAccessDemo
{

    public static void main(String[] args)
    {
        RandomAccessFile file = null;
        try
        {
            file = new RandomAccessFile("grades.txt", "r"); // read-only file
            while(!file.readLine().startsWith("Exams"))
            {
                file.seek(file.getFilePointer());
            }
            // Get the numbers and add them
        }
        catch (IOException e)
        {
             e.printStackTrace();
        }
        finally
        {
            try
            {
                file.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
