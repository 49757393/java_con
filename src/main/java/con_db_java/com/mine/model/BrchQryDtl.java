package com.mine.model;


import java.sql.*;


public class BrchQryDtl{
    private    String tran_date ;
    private    String timestampl;
    private    String acc ;
    private    Float amt ;
    private    Integer dr_cr_flag;  
    private    String rpt_sum ;

    public String getTranDate()
    {
        return tran_date;
    }
    public String getTimestampl()
    {
        return timestampl;
    }
    public String getAcc()
    {
        return acc;
    }
    public Float getAmt()
    {
        return amt;
    }
    public Integer getDrCrFlag()
    {
        return dr_cr_flag;
    }
    public String getRptSum()
    {
        return rpt_sum;
    }
    public void setTranDate(String tran_date)
    {
        this.tran_date=tran_date;
    }
    public void setTimestampl(String timestampl)
    {
        this.timestampl=timestampl;
    }
    public void setAcc(String acc)
    {
        this.acc=acc;
    }
    public void setAmt(Float amt)
    {
        this.amt=amt;
    }
    public void setDrCrFlag(Integer dr_cr_flag)
    {
        this.dr_cr_flag=dr_cr_flag;
    }
    public void setRptSum(String rpt_sum)
    {
        this.rpt_sum=rpt_sum;
    }                    
}