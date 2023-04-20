package model;

import java.sql.Date;

public class TaxFilers {
    private int filerID;
    private String name;
    private String contact;
    private double annualIncome;
    private double expenses;
    private int taxYear;
    private Date dateFiled;

    public int getFilerID() {
        return filerID;
    }

    public void setFilerID(int filerID) {
        this.filerID = filerID;
    }

    public String getName() {
        return name;
    }

    public TaxFilers(int filerID, String name, String contact, double annualIncome, double expenses, int taxYear,
			Date dateFiled) {
		super();
		this.filerID = filerID;
		this.name = name;
		this.contact = contact;
		this.annualIncome = annualIncome;
		this.expenses = expenses;
		this.taxYear = taxYear;
		this.dateFiled = dateFiled;
	}

	public TaxFilers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TaxFilers [filerID=" + filerID + ", name=" + name + ", contact=" + contact + ", annualIncome="
				+ annualIncome + ", expenses=" + expenses + ", taxYear=" + taxYear + ", dateFiled=" + dateFiled
				+ ", getFilerID()=" + getFilerID() + ", getName()=" + getName() + ", getContact()=" + getContact()
				+ ", getAnnualIncome()=" + getAnnualIncome() + ", getExpenses()=" + getExpenses() + ", getTaxYear()="
				+ getTaxYear() + ", getDateFiled()=" + getDateFiled() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public int getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

    public Date getDateFiled() {
        return dateFiled;
    }

    public void setDateFiled(Date dateFiled) {
        this.dateFiled = dateFiled;
    }
}
