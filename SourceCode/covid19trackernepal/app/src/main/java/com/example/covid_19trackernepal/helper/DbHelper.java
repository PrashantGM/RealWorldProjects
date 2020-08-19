package com.example.covid_19trackernepal.helper;

import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;;

import java.util.List;

/**
 * Created by ADMIN on 2017-11-07.
 */

public class DbHelper {

    public static void deleteTable(Class<? extends Model> type)
    {
        new Delete().from(type).execute();
    }

    public static List<?> getRecordsDb(Class<? extends Model> type){
        return new Select().from(type).execute();
    }

}
