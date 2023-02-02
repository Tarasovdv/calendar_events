import com.fasterxml.jackson.core.JsonProcessingException;
import model.DataBase;
import model.Event;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        DataBase db = new DataBase();
        Presenter presenter = new Presenter(view,db);

        view.start();



//        Calendar calendar = new GregorianCalendar();
//        String ev = "go";
//        Event event = new Event(calendar,ev);
//        System.out.println(event.getCalendarDate().get(Calendar.DAY_OF_MONTH));
//        System.out.println(event.getCalendarDate().getTime());

    }
}
