package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Event;
import presenter.Presenter;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public interface View {
    void start() throws IOException;

    void printNewEvent(Event event);
    void setPresenter(Presenter presenter);
    void printAllEvent(ArrayList<String> list)throws JsonProcessingException;
    void printEventForDay(ArrayList<String> list) throws JsonProcessingException;

}
