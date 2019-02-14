/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.HashMap;

/**
 *
 * @author Nastya
 */
public class GsonHelper {
    protected String defaultCity;

    protected HashMap<String, String> city = new HashMap<>();

    public GsonHelper(String defaultCity){
            city.put("defaultCity", defaultCity);
    }
}
