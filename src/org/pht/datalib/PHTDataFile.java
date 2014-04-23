package org.pht.datalib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PHTDataFile
{
    private final Charset CHARSET = Charset.forName("UTF-8");
    private static final Path FILE_PATH = Paths.get(System.getProperty("user.home")
            + "/PHT/phtdata.txt");
    private static final Path FOLDER_PATH = Paths.get(System.getProperty("user.home")
            + "/PHT");
    private File file;

    public PHTDataFile()
    {
        try {
            Files.createDirectories(FOLDER_PATH);
            file = this.FILE_PATH.toFile();
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.err
                    .println("Error creating file or file path in PHTDataFile constructor");
        }
    }

    public boolean loadDataTo(PHTData phtData)
    {
        try (BufferedReader br = Files.newBufferedReader(
                this.FILE_PATH.toAbsolutePath(), CHARSET)) {
            String line = null;
            int month, day, year, strengthHours, cardioHours, workHours, sleepHours, restingHeartRate, systolic, diastolic;
            double bloodSugar;
            while ((line = br.readLine()) != null) {
                month = new Integer(line);
                day = new Integer(br.readLine());
                year = new Integer(br.readLine());
                strengthHours = new Integer(br.readLine());
                cardioHours = new Integer(br.readLine());
                workHours = new Integer(br.readLine());
                sleepHours = new Integer(br.readLine());
                restingHeartRate = new Integer(br.readLine());
                systolic = new Integer(br.readLine());
                diastolic = new Integer(br.readLine());
                bloodSugar = new Double(br.readLine());
                phtData.add(month, day, year, strengthHours, cardioHours,
                        workHours, sleepHours, restingHeartRate, systolic,
                        diastolic, bloodSugar);
            }
            br.close();
            return true;
        } catch (NumberFormatException | IOException e) {
            return false;
        }
    }

    public boolean saveDataFrom(PHTData phtData)
    {
        try {
            BufferedWriter bw = Files.newBufferedWriter(this.FILE_PATH,
                    CHARSET, StandardOpenOption.TRUNCATE_EXISTING);
            String tmp;
            for (int i = 0; i < phtData.size(); i++) {
                tmp = phtData.get(i).toString();
                bw.write(tmp, 0, tmp.length());
            }
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
