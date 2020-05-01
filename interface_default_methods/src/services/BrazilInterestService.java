package services;

public class BrazilInterestService implements InterestService {

	private double interestRate;

	public BrazilInterestService() {
		interestRate = 2.0;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
