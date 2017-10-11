/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        String tabUnite [] = {" ","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tabDizaine [] = {" ","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String tabCentaine[] = {" ","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String tabMille[] = {" ","M","MM",};
        
        String nbUtilisateur = nbr.toString();
       
        int taille = nbUtilisateur.length();
        switch(taille){
            case 1 : return tabUnite[nbr]; 
            case 2 : return tabDizaine[(nbr/10)%10] + tabUnite[(nbr/1)%10]; 
            case 3 : return tabCentaine [(nbr/100)%10] + tabDizaine[(nbr/10)%10] + tabUnite[(nbr/1)%10] ;
            case 4 : return tabMille[(nbr/1000)%10] + tabCentaine [(nbr/100)%10] + tabDizaine[(nbr/10)%10] + tabUnite[(nbr/1)%10] ;  
            default :return  "mauvais chiffre";
                
        }
       // return new String("XVXX");
    }

}
