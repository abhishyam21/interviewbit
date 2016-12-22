package stringmatching;

import java.util.ArrayList;

/**
 * Created by Rachana Rao on 10/23/2016.
 */
public class PrettyJson {
    public static void main(String[] args) {
        PrettyJson prettyJson = new PrettyJson();
        String a = "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
        ArrayList<String> strings = prettyJson.prettyJSON(a);
        strings.forEach(System.out::println);
    }

    private ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<>();
        int wordCount = 0;
        int tabCount =0;
        String currentWord = "";
        while (wordCount < a.length()){
            char c = a.charAt(wordCount++);
                if(c == '{'){
                    result.addAll(getRcord("{",currentWord,tabCount++,true));
                    currentWord="";
                }else if( c== '}'){
                    result.addAll(getRcord("}",currentWord, tabCount--, false));
                    currentWord="";
                }else if( c == ']'){
                    result.addAll(getRcord("]",currentWord, tabCount--, false));
                    currentWord="";
                }else if( c == '['){
                    result.addAll(getRcord("[",currentWord, tabCount++, true));
                    currentWord="";
                }else if( c == ','){
                    for (int i = 0; i < tabCount; i++) {
                        currentWord= "\t"+currentWord;
                    }
                    String word = result.get(result.size()-1);
                    if(word.endsWith("}") || word.endsWith("]")){
                        word+=",";
                        result.set(result.size()-1,word);
                    }else
                    result.add(currentWord+",");
                    currentWord="";
                }else if(c == ' ') {

                }else {
                    currentWord+=c+"";
                }
        }
        return result;
    }

    private ArrayList<String> getRcord(String symbol, String currentWord, int tabCount, boolean isStarting) {
        ArrayList<String> result = new ArrayList<>();
        if(currentWord.equals("")){
            if(isStarting)
            result.add(getTabs(tabCount)+symbol);
            else
                result.add(getTabs(--tabCount)+symbol);
        }else {
            result.add(getTabs(tabCount)+currentWord);
            if(isStarting)
            result.add(getTabs(tabCount)+symbol);
            else
                result.add(getTabs(--tabCount)+symbol);
        }
        return result;
    }
    private String getTabs(int num){
        String tab = "";
        for (int i = 0; i < num; i++) {
            tab+="\t";
        }
        return tab;
    }
}
