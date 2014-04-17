/*
 * Description:
 * The user can add a desired amount of hours for each activity as well as the
 * desired health status in the quota management section. The software will 
 * use this data against the data input by the user for their activities 
 * completed.
 */

package org.pht.quota;

public class PHTQuota
{

    // Health goals
    private int restingHeartRateGoal, systolicGoal, diastolicGoal;
    double bloodSugarGoal;

    // Activity goals
    private int strengthGoal, cardioGoal, sleepGoal, workGoal;
    PHTQuotaFile phtquotafile;

    public PHTQuota()
    {
        this.phtquotafile = new PHTQuotaFile();
    }

    public PHTQuota(int strengthGoal, int cardioGoal, int workGoal,
            int sleepGoal, int restingHeartRateGoal, int systolicGoal, int diastolicGoal,
            double bloodSugarGoal)
    {
        this.strengthGoal = strengthGoal;
        this.cardioGoal = cardioGoal;
        this.workGoal = workGoal;
        this.sleepGoal = sleepGoal;
        this.restingHeartRateGoal = restingHeartRateGoal;
        this.systolicGoal = systolicGoal;
        this.diastolicGoal = diastolicGoal;
        this.bloodSugarGoal = bloodSugarGoal;
        this.phtquotafile = new PHTQuotaFile();
    }

    public void save()
    {
        this.phtquotafile.saveDataFrom(this);
    }

    public boolean load()
    {
        if (this.phtquotafile.loadDataTo(this)) return true;
        else return false;
    }
    
    public int getRestingHeartRateGoal()
    {
        return restingHeartRateGoal;
    }

    public void setRestingHeartRateGoal(int restingHeartRateGoal)
    {
        this.restingHeartRateGoal = restingHeartRateGoal;
    }

    public int getSystolicGoal()
    {
        return systolicGoal;
    }

    public void setSystolicGoal(int systolicGoal)
    {
        this.systolicGoal = systolicGoal;
    }

    public int getDiastolicGoal()
    {
        return diastolicGoal;
    }

    public void setDiastolicGoal(int diastolicGoal)
    {
        this.diastolicGoal = diastolicGoal;
    }

    public double getBloodSugarGoal()
    {
        return bloodSugarGoal;
    }

    public void setBloodSugarGoal(double bloodSugarGoal)
    {
        this.bloodSugarGoal = bloodSugarGoal;
    }

    public int getStrengthGoal()
    {
        return strengthGoal;
    }

    public void setStrengthGoal(int strengthGoal)
    {
        this.strengthGoal = strengthGoal;
    }

    public int getCardioGoal()
    {
        return cardioGoal;
    }

    public void setCardioGoal(int cardioGoal)
    {
        this.cardioGoal = cardioGoal;
    }

    public int getSleepGoal()
    {
        return sleepGoal;
    }

    public void setSleepGoal(int sleepGoal)
    {
        this.sleepGoal = sleepGoal;
    }

    public int getWorkGoal()
    {
        return workGoal;
    }

    public void setWorkGoal(int workGoal)
    {
        this.workGoal = workGoal;
    }

    @Override
    public String toString()
    {
        return (this.strengthGoal + "\n" + this.cardioGoal + "\n"
                + this.workGoal + "\n" + this.sleepGoal + "\n"
                + this.restingHeartRateGoal + "\n" + this.systolicGoal + "\n"
                + this.diastolicGoal + "\n" + this.bloodSugarGoal);
    }

    public int getWeeklyStrength()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklyCardio()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklyWork()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklySleep()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklyRestingHeartRate()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklySystolic()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklyDiastolic()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getWeeklyBloodSugar()
    {
        // TODO Auto-generated method stub
        return 0;
    }
}
