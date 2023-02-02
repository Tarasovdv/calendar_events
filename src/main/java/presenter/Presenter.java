package presenter;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.DataBase;
import model.Event;
import view.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Presenter {
    private View view;
    private DataBase db;
    //private FileWriter file = new FileWriter("C:\\Users\\Тарасов Дмитрий\\IdeaProjects\\calendar_events\\database.txt", true);

    public Presenter(View view, DataBase db) throws IOException {
        this.view = view;
        this.db = db;
        view.setPresenter(this);

    }


//    public void onClick(String city) {
//        String weather = service.get(city);
//        view.printAnswer(weather);
//    }

    public void newEvent(Event event) throws IOException {
        //db.printJson(event);
        db.writeEvent(event);

        view.printNewEvent(event);
    }

    public void allEvent() throws JsonProcessingException {
        view.printAllEvent(db.readEvent());
    }

    public void dayEvent() throws JsonProcessingException {
        view.printEventForDay(db.readEvent());
    }
}
