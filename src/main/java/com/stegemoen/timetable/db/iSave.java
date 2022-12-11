package com.stegemoen.timetable.db;

public interface iSave<T> {
    // ToDo: make a similar interface for methods with ID from other objects, unless it's possible to have them in the same file
    int saveToDB(T t);
}
