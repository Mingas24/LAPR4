package presentation;

import app.ProcessMessageController;
import eapli.framework.presentation.console.AbstractUI;

import eapli.framework.util.Console;

import java.time.LocalDate;
import java.util.Date;

public class ProcessMessageUI extends AbstractUI {

    private final ProcessMessageController controller = new ProcessMessageController();

    @Override
    protected boolean doShow() {
        String list = Console.readLine("What Production Lines would you like to process the messages from?(separeted by ',')");
        String[] pls = list.split(",");
        String begin = Console.readLine("What date would you like to process?(YYYY-MM-DD-HH-MM-SS)n");
        String end = Console.readLine("To what time would you like to process?(HH-MM-SS)n");
        String[] day1 = begin.split("-");
        String[] end1 = end.split("-");
        Date date = new Date(Integer.parseInt(day1[0])-1900, Integer.parseInt(day1[1])-1, Integer.parseInt(day1[2]),
                Integer.parseInt(day1[3]), Integer.parseInt(day1[4]), Integer.parseInt(day1[5]));
        Date date1 = new Date(Integer.parseInt(day1[0])-1900, Integer.parseInt(day1[1])-1, Integer.parseInt(day1[2]),
                Integer.parseInt(end1[0]), Integer.parseInt(end1[1]), Integer.parseInt(end1[2]));

        try {
            controller.processmentThreadBlock(pls, date, date1);
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Process Messages";
    }
}
