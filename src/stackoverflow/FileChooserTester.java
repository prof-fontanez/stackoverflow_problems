package stackoverflow;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserTester
{

    public Boolean loadMDBFile()
    {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter(
                "*.mdb", "mdb");
        fc.addChoosableFileFilter(fileExtensionFilter);
        fc.setDialogTitle("Open");

        int returnVal = fc.showOpenDialog(null);

        if (returnVal != JFileChooser.APPROVE_OPTION)
        {
            return null;
        }
        else
        {
            try
            {

                // process file

            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }

            return true;
        }

    }

    public static void main(String[] args)
    {
        new FileChooserTester().loadMDBFile();

    }
}
