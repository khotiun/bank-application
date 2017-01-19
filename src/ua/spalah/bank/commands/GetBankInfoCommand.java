package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.services.iml.BankReportServiceImpl;

/**
 * Created by MyPc on 19.01.2017.
 */
public class GetBankInfoCommand implements Command {//печатает полную информацию о банке

    BankReportServiceImpl bankReportService;

    public GetBankInfoCommand(BankReportServiceImpl bankReportService) {
        this.bankReportService = bankReportService;
    }

    @Override
    public void execute() {
        System.out.println(bankReportService.getClientsSortedByName(BankCommander.currentBank).toString());
        System.out.println(bankReportService.getNumberOfAccounts(BankCommander.currentBank));
        System.out.println(bankReportService.getNumberOfClients(BankCommander.currentBank));
        System.out.println(bankReportService.getTotalAccountSum(BankCommander.currentBank));
        System.out.println(bankReportService.getBankCreditSum(BankCommander.currentBank));
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"10\" for take Get Bank Info command");
    }
}
