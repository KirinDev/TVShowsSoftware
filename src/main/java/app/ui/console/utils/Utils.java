package app.ui.console.utils;

import app.mappers.dto.AnimeDTO;
import app.mappers.dto.MovieDTO;
import app.mappers.dto.SerieDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    static public String readLineFromConsole(String prompt) {
        try
        {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    static public int readIntegerFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                int value = Integer.parseInt(input);

                return value;
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public double readDoubleFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                double value = Double.parseDouble(input);

                return value;
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public float readFloatFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                float value = Float.parseFloat(input);

                return value;
            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public Date readDateFromConsole(String prompt)
    {
        do
        {
            try
            {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole("\n" + message + "\n");
        } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

        return input.equalsIgnoreCase("yes");
    }

    static public Object showAndSelectOne(List list, String header)
    {
        showList(list,header);
        return selectsObject(list);
    }
    static public int showAndSelectIndex(List list, String header)
    {
        showList(list,header);
        return selectsIndex(list);
    }
    static public void showList(List list, String header)
    {
        System.out.println(header);

        int index = 0;
        for (Object o : list)
        {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }

    static public Object selectsObject(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0)
        {
            return null;
        } else
        {
            return list.get(value - 1);
        }
    }

    static public int selectsIndex(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    static public void printAnimeInfo(List<AnimeDTO> ani_lst) {

        for (AnimeDTO i : ani_lst) {
            System.out.println("\n===================");
            System.out.println("| Name: " + i.getName());
            System.out.println("| Aired: " + i.getAired());
            System.out.println("| Genres: " + i.getGenres());
            System.out.println("| Studio: " + i.getStudio());
            System.out.println("| Type: " + i.getType());
            System.out.println("| Duration: " + i.getDuration());
            System.out.println("| Score: " + i.getScore());
            System.out.println("| Number of episodes: " + i.getNum_episodes());
            System.out.println("===================");
        }
    }

    static public void printMovieInfo(List<MovieDTO> lst) {
        for(MovieDTO i : lst) {
            System.out.println("===================");
            System.out.println("| Name: " + i.getName());
            System.out.println("| Aired: " + i.getAired());
            System.out.println("| Genres: " + i.getGenres());
            System.out.println("| Duration: " + i.getDuration());
            System.out.println("| Score: " + i.getScore());
            System.out.println("===================");
        }
    }

    static public void printSeriesInfo(List<SerieDTO> lst) {
        for(SerieDTO i : lst) {
            System.out.println("===================");
            System.out.println("| Name: " + i.getName());
            System.out.println("| Aired: " + i.getAired());
            System.out.println("| Genres: " + i.getGenres());
            System.out.println("| Duration: " + i.getDuration());
            System.out.println("| Score: " + i.getScore());
            System.out.println("| Number of episodes: " + i.getNum_episodes());
            System.out.println("===================");
        }

    }
}
