import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mindtree.entity.Account.Account;
import com.mindtree.entity.AccountService.AccountService;
import com.mindtree.exception.AccountCreationException;
import com.mindtree.exception.AccountTransactionException;
import com.mindtree.exception.BankingApplicationException;
import com.mindtree.exception.InsufficientBalanceException;
import com.mindtree.exception.InvalidAmountException;

public class AccountMain {
	private static Scanner scan = new Scanner(System.in);
	public static final Logger LOGGER = Logger.getLogger(AccountMain.class);
	static int i, x = 0, y = 0;
	static int accountNo;
	static int fromaccountNo;
	static int toaccountNo;
	static String choice;
	static double amount;
	static AccountService as = new AccountService();

	public static void main(String[] args) {
		LOGGER.debug("Banking Account Process Started");
		try {
			create();
		} catch (BankingApplicationException e1) {
			LOGGER.debug("Account Creation Failed");
			System.out.println(e1.getMessage());
		}
		print();
		i = 0;
		while (true) {
			System.out.println("");
			if (i != 0)
				scan.nextLine();
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Transfer");
			System.out.println("4.Balance Enquiry");
			System.out.println("Press other key to exit");
			System.out.println("Enter your choice");
			choice = scan.nextLine();
			i++;
			try
			{
			switch (choice) {
			case "1":
				deposit();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				transfer();
				break;
			case "4":
				balanceEnquiry();
				break;
			default:
				print();
				LOGGER.debug("Banking Account Process Ended");
				System.exit(0);
			}
			} catch (BankingApplicationException e1) {
				LOGGER.debug("Account Creation Failed");
				System.out.println(e1.getMessage());
			}
		}
	}

	private static void create() throws BankingApplicationException {
		System.out.println("Create 5 new Account");
		for (i = 0; i < 5;) {
			as.accounts[i] = new Account();
			try {
				as.createAccount(as.accounts[i]);
				i++;
			} catch (AccountCreationException e) {
				LOGGER.debug("Account Creation Failed");
				System.out.println(e.getMessage());
				throw new BankingApplicationException("Account Creation Failed");
			}
		}
	}

	public static void deposit() throws BankingApplicationException {
		x = 0;
		while (true) {
			try {
				System.out.println("Enter the Account Number");
				accountNo = scan.nextInt();
				if (accountNo > 0) {
					for (int i = 0; i < as.count; i++) {
						if (as.accounts[i].accountNo == accountNo) {
							while (true) {
								try {

									System.out
											.println("Enter amount to deposit : ");
									amount = scan.nextDouble();
									System.out
											.println("Before depositing amount in an Account : "
													+ as.accounts[i].accountNo
													+ " & Balance : "
													+ as.accounts[i]
															.getBalance());
									as.accounts[i].deposit(amount);
									System.out
											.println("After depositing amount in an Account : "
													+ as.accounts[i].accountNo
													+ " & Balance : "
													+ as.accounts[i]
															.getBalance());
									x = 1;
									break;
								} catch (InvalidAmountException e) {
									LOGGER.debug("Balance Amount Invalid");
									//System.out.println(e.getMessage());
									throw new BankingApplicationException("Balance Amount Invalid");
								} catch (Exception e) {
									LOGGER.debug("Balance Amount Invalid Input Type");
									System.out.println(e.getMessage());
									scan.next();
								}
							}
							break;
						}
					}
					if (x == 0)
						System.out.println("Account not found");
					break;
				} else {
					LOGGER.debug("Account Number Invalid");
					System.out.println("Enter valid Account Number");
				}
			} catch (Exception e) {
				LOGGER.debug("Account Number Invalid Input Type");
				System.out.println(e.getMessage());
				scan.next();
			}
		}
	}

	public static void withdraw() throws BankingApplicationException {
		x = 0;
		while (true) {
			try {
				System.out.println("Enter the Account Number");
				accountNo = scan.nextInt();
				if (accountNo > 0) {
					for (int i = 0; i < as.count; i++) {
						if (as.accounts[i].accountNo == accountNo) {
							while (true) {
								try {

									System.out
											.println("Enter amount to withdraw : ");
									amount = scan.nextDouble();
									System.out
											.println("Before withdraw amount in an Account : "
													+ as.accounts[i].accountNo
													+ " & Balance : "
													+ as.accounts[i]
															.getBalance());
									as.accounts[i].withdraw(amount);
									System.out
											.println("After withdraw amount in an Account : "
													+ as.accounts[i].accountNo
													+ " & Balance : "
													+ as.accounts[i]
															.getBalance());
									x = 1;
									break;
								} catch (InvalidAmountException e) {
									LOGGER.debug("Invalid Balance Amount");
									//System.out.println(e.getMessage());
									throw new BankingApplicationException("Invalid Balance Amount");
								} catch (InsufficientBalanceException e) {
									LOGGER.debug("Insufficient Balance in Account");
									//System.out.println(e.getMessage());
									throw new BankingApplicationException("Insufficient Balance in Account");
								} catch (Exception e) {
									LOGGER.debug("Balance Amount Invalid Input Type");
									System.out.println(e.getMessage());
									scan.next();
								}
							}
							break;
						}
					}
					if (x == 0)
						System.out.println("Account not found");
					break;
				} else {
					LOGGER.debug("Account Number Invalid");
					System.out.println("Enter valid Account Number");
				}
			} catch (Exception e) {
				LOGGER.debug("Account Number Invalid Input Type");
				System.out.println(e.getMessage());
				scan.next();
			}
		}
	}

	public static void balanceEnquiry() {
		x = 0;
		while (true) {
			try {
				System.out.println("Enter the Account Number");
				accountNo = scan.nextInt();
				if (accountNo > 0) {
					for (int i = 0; i < as.count; i++) {
						if (as.accounts[i].accountNo == accountNo) {
							System.out.println("Balance amount in Account "
									+ as.accounts[i].accountNo + " : "
									+ as.accounts[i].getBalance());
							x = 1;
							break;
						}
					}
					if (x == 0)
						System.out.println("Account not found");
					break;
				} else {
					LOGGER.debug("Account Number Invalid");
					System.out.println("Enter valid Account Number");
				}
			} catch (Exception e) {
				LOGGER.debug("Account Number Invalid Input Type");
				System.out.println(e.getMessage());
				scan.next();
			}
		}
	}

	public static void transfer() throws BankingApplicationException {
		x = 0;
		y = 0;
		while (true) {
			try {
				System.out.println("Enter the Payer Account Number");
				fromaccountNo = scan.nextInt();
				if (fromaccountNo > 0) {
					for (int i = 0; i < as.count; i++) {
						if (as.accounts[i].accountNo == fromaccountNo) {
							x = 1;
							while (true) {
								try {
									System.out
											.println("Enter the Receiver Account Number");
									toaccountNo = scan.nextInt();
									if (toaccountNo > 0) {
										for (int j = 0; j < as.count; j++) {
											if (as.accounts[j].accountNo == toaccountNo) {
												y = 1;
												while (true) {
													try {

														System.out
																.println("Enter amount to transfer : ");
														amount = scan
																.nextDouble();
														if(amount<1)
														{
															LOGGER.debug("Balance Amount Invalid");
															System.out
																	.println("Enter valid amount");
															continue;
														}
														System.out
																.println("Before Transferring amount");
														System.out
																.println("Balance Amount in Account "
																		+ as.accounts[i].accountNo
																		+ " : "
																		+ as.accounts[i]
																				.getBalance());
														System.out
																.println("Balance Amount in Account "
																		+ as.accounts[j].accountNo
																		+ " : "
																		+ as.accounts[j]
																				.getBalance());
														as.transferFunds(
																as.accounts[i],
																as.accounts[j],
																amount);
														System.out
																.println("After Transferring amount");
														System.out
																.println("Balance Amount in Account "
																		+ as.accounts[i].accountNo
																		+ " : "
																		+ as.accounts[i]
																				.getBalance());
														System.out
																.println("Balance Amount in Account "
																		+ as.accounts[j].accountNo
																		+ " : "
																		+ as.accounts[j]
																				.getBalance());
														break;
													} catch (InsufficientBalanceException e) {
														LOGGER.debug("Insufficient Balance in Account");
														//System.out.println(e.getMessage());
														throw new BankingApplicationException("Insufficient Balance in Account");
													} catch (AccountTransactionException e) {
														LOGGER.debug("Account Transcation Cancelled");
														//System.out.println(e.getMessage());
														throw new BankingApplicationException("Account Transcation Cancelled");
														//break;
													} catch (Exception e) {
														LOGGER.debug("Balance Amount Invalid Input Type");
														System.out.println(e
																.getMessage());
														scan.next();
													}
												}
												break;
											}
										}
										if (y == 0)
											System.out
													.println("Receiver Account not found");
										break;
									} else {
										LOGGER.debug("Receiver Account Number Invalid");
										System.out
												.println("Enter valid Account Number");
									}
								} catch (Exception e) {
									LOGGER.debug("Receiver Account Number Invalid Input Type");
									System.out.println(e.getMessage());
									scan.next();
								}
							}
							break;
						}
					}
					if (x == 0)
						System.out.println("Payer Account not found");
					break;
				} else {
					LOGGER.debug("Payer Account Number Invalid");
					System.out.println("Enter valid Account Number");
				}
			} catch (Exception e) {
				LOGGER.debug("Payer Account Number Invalid Input Type");
				System.out.println(e.getMessage());
				scan.next();
			}
		}
	}

	public static void print() {
		System.out.println("\nAccount details \n");
		System.out.println("Account No\t\t CustomerName\t\t  Balance");
		String space, num;
		for (int i = 0; i < 5; i++) {
			num = String.valueOf(as.accounts[i].accountNo);
			space = "";
			for (int j = 0; j < (25 - num.length()); j++)
				space = space + " ";
			System.out.printf("%d%s", as.accounts[i].accountNo, space);
			space = "";
			for (int j = 0; j < (25 - as.accounts[i].customerName.length()); j++)
				space = space + " ";
			System.out.printf("%s%s%f", as.accounts[i].customerName, space,
					as.accounts[i].balance);
			System.out.println("");
		}
	}
}
