package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import presenter.Presenter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() throws IOException {
        init();

    }

    @Override
    public void printNewEvent(Event event) {
        System.out.println("_______________________");
        System.out.println("the Event is recorded: ");
        DateFormat df = new SimpleDateFormat("E  HH:mm / dd MMM yyyy");
        System.out.println(df.format(event.getCalendarDate().getTime()));
        System.out.println("Event: " + event.getEventDate());
        System.out.println("-----------------------");
        //System.out.println(answer.getTime());

    }

    @Override
    public void printAllEvent(ArrayList<String> list) throws JsonProcessingException {
        for (String el:list) {
            Event event = new ObjectMapper().readValue(el, Event.class);
            DateFormat df = new SimpleDateFormat("E  HH:mm / dd MMM yyyy");
            System.out.println(df.format(event.getCalendarDate().getTime()));
            System.out.println("Event: " + event.getEventDate());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void printEventForDay(ArrayList<String> list) throws JsonProcessingException {
        Calendar calendar1 = new GregorianCalendar();
        System.out.print("Input MONTH: ");
        calendar1.set(Calendar.MONTH, Integer.parseInt(scanner.nextLine()));
        System.out.print("Input DAY_OF_MONTH: ");
        calendar1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(scanner.nextLine()));
        for (String el:list) {
            Event event = new ObjectMapper().readValue(el, Event.class);
            if ((event.getCalendarDate().get(Calendar.MONTH)
                    == calendar1.get(Calendar.MONTH))&&(event.getCalendarDate().get(Calendar.DAY_OF_MONTH)
                    == calendar1.get(Calendar.DAY_OF_MONTH))){
                DateFormat df = new SimpleDateFormat("E  HH:mm / dd MMM yyyy");
                System.out.println(df.format(event.getCalendarDate().getTime()));
                System.out.println("Event: " + event.getEventDate());
                System.out.println("-----------------------");

            }
        }



    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    private void init() throws IOException {
        menu();


//        Calendar scan = dataScan();
//        //System.out.println(scan.getTime());
//        presenter.onClick(scan);
    }

    private Calendar dataScan() {
        Calendar calendar = new GregorianCalendar();
//        System.out.println("Input YEAR");
//        calendar.set(Calendar.YEAR, Integer.parseInt(scanner.nextLine()));
        System.out.print("Input MONTH: ");
        calendar.set(Calendar.MONTH, Integer.parseInt(scanner.nextLine()));
        System.out.print("Input DAY_OF_MONTH: ");
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(scanner.nextLine()));
        System.out.print("Input HOUR_OF_DAY: ");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(scanner.nextLine()));
        System.out.print("Input MINUTE: ");
        calendar.set(Calendar.MINUTE, Integer.parseInt(scanner.nextLine()));
        //calendar.set(Calendar.SECOND, Integer.parseInt(scanner.nextLine()));
        //System.out.println(calendar.getTime());
        return calendar;
    }

    private String busyScan() {
        String busy = new String();
        System.out.print("Input Busy: ");
        busy = scanner.nextLine();
        return busy;

    }

    private void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choise;
        do {
            printMenu();
            choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Просмотр всех записей");
                    presenter.allEvent();
                    break;
                case 2:
                    System.out.println("Добавить запись");
                    Event event = new Event(dataScan(), busyScan());
                    presenter.newEvent(event);

                    break;
                case 3:
                    System.out.println("Просмотр дел на день");
                    presenter.dayEvent();
                    break;
                default:
//                    System.out.println("not found");

            }
        } while (choise != 0);
    }

    private void printMenu() {
        System.out.println("Menu: ");
        System.out.println("|____1____|____2_____|____3_____|____0____|");
        System.out.println("|Просмотр |Доб.запись|Дела(день)|__Выход__|");
    }


}
