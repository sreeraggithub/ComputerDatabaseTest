/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerdatabasetest;

import java.util.Date;

/**
 *
 * @author sreer
 */
public class Computer {
    private String computerName;
    private Date introduced;
    private Date discontinued;
    private String companyName;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Date getIntroduced() {
        return introduced;
    }

    public void setIntroduced(Date introduced) {
        this.introduced = introduced;
    }

    public Date getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Date discontinued) {
        this.discontinued = discontinued;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    
}
