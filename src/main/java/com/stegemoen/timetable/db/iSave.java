package com.stegemoen.timetable.db;

public interface iSave<T> {
    // Some classes requires more than one parameter, and doesn't use this interface atm
    int saveToDB(T t);
}
