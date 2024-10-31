package com.example.dailyjournalapp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Diary implements Serializable {

    private String m_DateCreated = "";
    private String m_DateUpdated = "";
    private String m_TimeCreated = "";
    private String m_TimeUpdated = "";
    private String m_Title = "";
    private final List<String> m_Pages = new ArrayList<String>();

    public Diary()
    {
        LocalDateTime now = LocalDateTime.now();
        m_DateCreated = now.toLocalDate().toString();
        m_TimeCreated = now.toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        m_DateUpdated = m_DateCreated;
        m_TimeUpdated = m_TimeCreated;
        m_Title = m_DateCreated;
        m_Pages.add("");
    }

    public Diary(String title)
    {
        this();
        m_Title = title.isEmpty() || title.isBlank() ? m_DateCreated : title;
    }

    public String getDateCreated() { return m_DateCreated; }
    public String getTimeCreated() { return m_TimeCreated; }
    public String getDateUpdated() { return m_DateUpdated; }
    public String getTimeUpdated() { return m_TimeUpdated; }
    public String getTitle() { return m_Title; }
    public List<String> getPages() { return m_Pages; }

    public void setDateUpdate() { m_DateUpdated = LocalDateTime.now().toLocalDate().toString(); }
    public void setTimeUpdate() { m_TimeUpdated = LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a")); }
    public void addPage(String entry) { m_Pages.add(entry); }
    public void editPage(int page_number, String entry) { m_Pages.set(page_number, entry); }
}
