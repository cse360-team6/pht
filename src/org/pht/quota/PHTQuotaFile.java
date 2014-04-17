package org.pht.quota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PHTQuotaFile
{
    private final Charset CHARSET = Charset.forName("UTF-8");
    private final Path FILE_PATH = Paths.get(System.getProperty("user.home")
            + "/PHT/phtquota.txt");
    private final Path FOLDER_PATH = Paths.get(System.getProperty("user.home")
            + "/PHT");
    private File file;

    public PHTQuotaFile()
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

    public boolean loadDataTo(PHTQuota q)
    {
        try (BufferedReader br = Files.newBufferedReader(
                this.FILE_PATH.toAbsolutePath(), CHARSET)) {
            String line = null;
            if ((line = br.readLine()) != null) {
                q.setStrengthGoal(new Integer(line));
                q.setCardioGoal(new Integer(br.readLine()));
                q.setWorkGoal(new Integer(br.readLine()));
                q.setSleepGoal(new Integer(br.readLine()));
                q.setRestingHeartRateGoal(new Integer(br.readLine()));
                q.setSystolicGoal(new Integer(br.readLine()));
                q.setDiastolicGoal(new Integer(br.readLine()));
                q.setBloodSugarGoal(new Double(br.readLine()));
            }
            br.close();
            return true;
        } catch (NumberFormatException | IOException e) {
            return false;
        }
    }

    public boolean saveDataFrom(PHTQuota q)
    {
        try {
            BufferedWriter bw = Files.newBufferedWriter(this.FILE_PATH,
                    CHARSET, StandardOpenOption.TRUNCATE_EXISTING);
            String str = q.toString();
            bw.write(str, 0, str.length());
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
