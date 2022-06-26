package com.Attractor;

public interface DataBase {
    void openConnection();
    void closeConnection();
    void checkToConnection();
    void checkToRecordThisKey();
    void readOneRecordByKey();
    void readSetRecordsFromDataBase();
    void numberOfRecordsInDataBase();
    void addRecordDataBase();
    void updateRecordByIndex();
    void updateEntryKey();
}
