import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class formatter extends AbstractFormatter {

	// creating the date pattern
    private String datePattern = "yyyy-MM-dd";
    //creating the date formatter
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override //overriding the string to value method
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override //overriding the value to string method
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}

