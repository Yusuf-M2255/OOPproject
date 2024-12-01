package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Slang {
    public List<Float> floats;
    public List<String> strings;
    public List<Long> longs;
    public List<Integer> integers;
    public List<Date> dates;
    Scanner sc = null;
    String FilePath,Line;
    public char[] Code;
    List<String>data;
    Integer i = 0;
    Long size;
    ReturnedData returnedData;
    public Slang(File file, String Code) {
        this.floats = new ArrayList<>();
        this.strings = new ArrayList<>();
        this.longs = new ArrayList<>();
        this.integers = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.Code=Code.toCharArray();
        try {
            sc = new Scanner(file);
        }catch(FileNotFoundException e) {
            System.out.println(file.getName() + "Not found");
        }
        this.FilePath=file.getAbsolutePath();
        returnedData=new ReturnedData();
        data=new ArrayList<>();
    }
    public void Reset (){
        returnedData=new ReturnedData();
    }
    public void SplitLine(){
        data.clear();
        String[] da = Line.split(" ");
        for(String line : da){
            data.add(line);
        }
    }

    public void ClearAll(){
        floats.clear();
        strings.clear();
        longs.clear();
        integers.clear();
        dates.clear();
    }

    public String NextLine(){
        return sc.nextLine();
    }

    public boolean notNull(){
        return sc.hasNextLine();
    }

    public Float ParseFloat(String s){
        return Float.parseFloat(s);
    }

    public Long ParseLong(String s){
        return Long.parseLong(s);
    }

    public int ParseInt(String s){
        return Integer.parseInt(s);
    }

    public Date ParseDate(String s){
        try {
            return DateFormat.getInstance().parse(s);
        }catch (ParseException e){
            System.out.println("Parsing Date in "+ FilePath + " is Failed");
        }
        return null;
    }
    public void KeyWords(char c){

        switch (c) {
            case 'n':
                Line = NextLine();
                data.clear();
                i = 0;
                data.add(Line);
                break;
            case 's':
                SplitLine();
                i = 0;
                break;
            case 'S':
                returnedData.strings.add(data.get(i++));
                break;
            case 'f':
                returnedData.floats.add(ParseFloat(data.get(i++)));
                break;
            case 'd':
                returnedData.dates.add(ParseDate(data.get(i++)));
                break;
            case 'i':
                returnedData.integers.add(ParseInt(data.get(i++)));
                break;
            case 'l':
                returnedData.longs.add(ParseLong(data.get(i++)));
                break;
        }
    }
    public void KeyWordsLoop(char c){

        switch (c) {
            case 'S':
                strings.add(data.get(i++));
                break;
            case 'f':
                floats.add(ParseFloat(data.get(i++)));
                break;
            case 'd':
                dates.add(ParseDate(data.get(i++)));
                break;
            case 'i':
                integers.add(ParseInt(data.get(i++)));
                break;
            case 'l':
                longs.add(ParseLong(data.get(i++)));
                break;
        }
    }

    public void pushing(char c){

        switch (c) {
            case 'S':
                returnedData.stringLists.add(new ArrayList<>());
                returnedData.stringLists.get(returnedData.stringLists.size()-1).addAll(strings);
                break;
            case 'f':
                returnedData.floatLists.add(new ArrayList<>());
                returnedData.floatLists.get(returnedData.floatLists.size()-1).addAll(floats);
                break;
            case 'd':
                returnedData.dateLists.add(new ArrayList<>());
                returnedData.dateLists.get(returnedData.dateLists.size()-1).addAll(dates);
                break;
            case 'i':
                returnedData.integerLists.add(new ArrayList<>());
                returnedData.integerLists.get(returnedData.integerLists.size()-1).addAll(integers);
                break;
            case 'l':
                returnedData.longLists.add(new ArrayList<>());
                returnedData.longLists.get(returnedData.longLists.size()-1).addAll(longs);
                break;
        }
    }
    public void Compile(char[] Code){
        for (int j = 0;j<Code.length;j++) {
            if (Code[j] == 'o') {
                ClearAll();
                size = ParseLong(data.get(i++));
                j++;
                for (int k = 0;k<size;k++) {
                    KeyWordsLoop(Code[j]);
                }
                pushing(Code[j]);
            }else if(Code[j]=='w'){
                j++;
                long sz = 0;
                StringBuilder s= new StringBuilder();
               while(Code[j]>='0' && Code[j]<='9'){
                   sz *=10;
                   sz+=Code[j]-'0';
                   j++;
               }
               while(Code[j]!='W'){
                   s.append(Code[j]);
                   j++;
               }
               for (int k = 0;k<sz;k++) {
                   Compile(s.toString().toCharArray());
               }
            }else{
                KeyWords(Code[j]);
            }
        }
    }


    public ReturnedData Run(char[] Code){
        Reset();
        Compile(Code);
        return returnedData;
    }
}
