package com.example.dailyjournalapp;

import java.util.ArrayList;
import java.util.List;

public class DiaryDB
{
    static private final List<Diary> m_Diaries = new ArrayList<Diary>();

    public static void addDiary(Diary diary) { m_Diaries.add(diary); }
    public static List<Diary> getDiaries() { return m_Diaries; }
    public static Diary getDiaries(int i) { return m_Diaries.get(i); }
    public static String[] getTitles()
    {
        String[] diary_titles = new String[m_Diaries.size()];

        for(int i = 0; i < m_Diaries.size(); i++)
        {
            diary_titles[i] = m_Diaries.get(i).getTitle();
        }
        
        return diary_titles;
    }
    public static void updateDiary(Diary diary, int index)
    {
        m_Diaries.set(index, diary);
    }
}
